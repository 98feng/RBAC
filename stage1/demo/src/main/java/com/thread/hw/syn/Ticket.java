package com.thread.hw.syn;

import lombok.Data;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author feng
 * @date 2021/1/5
 * @Description
 */
public class Ticket {
    static int ticket = 10;

    public static void main(String[] args) {
        AbleLock ableLock = new AbleLock();
        SelfLock selfLock = new SelfLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                selfLock.lock();
                while (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "拿到了第" + ticket);
                    ticket--;
                }
                selfLock.unlock();
            }
        };

        new Thread(runnable, "t1").start();
        new Thread(runnable, "t2").start();
        new Thread(runnable, "t3").start();
    }
}

class TestTicket {
    public static void main(String[] args) {
        AllTicket allTicket = new AllTicket();
        allTicket.setTicket(10);

        ByTickets byTickets1 = new ByTickets(allTicket);
        ByTickets byTickets2 = new ByTickets(allTicket);
        ByTickets byTickets3 = new ByTickets(allTicket);

        new Thread(byTickets1, "t1").start();
        new Thread(byTickets2, "t2").start();
        new Thread(byTickets3, "t3").start();
    }

    @Data
    static class AllTicket {
        private int ticket;
    }

    @Data
    static class ByTickets implements Runnable {
        private final AllTicket ticket;

        @Override
        public void run() {
            synchronized (ticket) {
                while (ticket.getTicket() > 0) {
                    System.out.println(Thread.currentThread().getName() + "第几张票" + ticket.getTicket());
                    int ticket = this.ticket.getTicket();
                    this.ticket.setTicket(--ticket);
                }

            }
        }
    }

}

class AbleLock {
    //新建一个原子引用类，负责操作当前线程
    AtomicReference<Thread> reference = new AtomicReference<Thread>();
    Thread thread = null;

    public void lock() {
        //获取当前的线程，如果是空的话，则进行cas操作
        thread = Thread.currentThread();
        if (reference.get() == null) {
            reference.compareAndSet(null, thread);
        }
    }

    public void unlock() {
        //这里没有使用cas设置为null，原因是刚开始是很多线程同时在争抢，
        //而拿到资源的线程只有一个，所以不必使用cas操作
        reference.set(null);
    }
}

class SelfLock implements Lock {

    private static class Sync extends AbstractQueuedSynchronizer {
        //state 表示是否处于占用,1为占用，0为没有
        //当前锁是否处于占用
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new UnsupportedOperationException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        public Condition newCondition() {
            return new ConditionObject();
        }
    }

    private Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}