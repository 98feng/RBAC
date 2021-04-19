package com.thread.hw;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author feng
 * @date 2021/1/4
 * @Description 模拟取钱
 */
public class HW {

    public static void main(String[] args) {

        Account account = new Account("1001", 100);
        WithDrawThread thread1 = new WithDrawThread(account, 50);
        WithDrawThread thread2 = new WithDrawThread(account, 50);
        WithDrawThread thread3 = new WithDrawThread(account, 50);
        new Thread(thread1, "You").start();
        new Thread(thread2, "Wife").start();
        new Thread(thread3, "lover").start();
    }
}

@Data
@AllArgsConstructor
class Account {
    private String accountId;
    /**
     * 余额
     */
    private double balance;
}

@Data
@AllArgsConstructor
class WithDrawThread implements Runnable {
    private final Account account;
    /**
     * 要取款的额度
     */
    private double withDraw;

    @Override
    public void run() {
        synchronized (account) {
            if (account.getBalance() >= withDraw) {
                System.out.println(Thread.currentThread().getName() + "取款之前的余额：" + account.getBalance());
                System.out.println("取款成功!取款：" + withDraw);
                account.setBalance(account.getBalance() - withDraw);
                System.out.println("取款之后的余额：" + account.getBalance());
            } else {
                System.out.println(Thread.currentThread().getName() + "取款失败,余额不足！要取得钱为：" + withDraw);
            }
        }
    }
}



