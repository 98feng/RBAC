package bjpowernode.test.mj.Test;


import bjpowernode.test.mj.circle.SingleCircleLinkedList;

/**
 * @author feng
 * @date 2020/12/2 - 10:46
 * @Description
 */
public class SingleCircleLinkedListTest {
    public static void main(String[] args) {
        SingleCircleLinkedList arrayList2 = new SingleCircleLinkedList();
        arrayList2.add(213);
        arrayList2.add(123);
        arrayList2.add(321);
        arrayList2.add(345);
        System.out.println(arrayList2);
        arrayList2.remove(0);
        arrayList2.remove(2);

    }
}
