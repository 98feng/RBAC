package day02.com.bjpowerndoe.circel;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author feng
 * @date 2020/12/21
 * @Description
 */
public class CircleDeque<E> extends AbstractList<E> {

    private int front;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleDeque(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }


    public CircleDeque() {
        this(DEFAULT_CAPACITY);
    }


    /**
     * @param index element
     * @return void
     * @Description add O(1) || O(size >> 1) == O(n)
     * @date 2020/12/23
     */
    @Override
    public void add(int index, E element) {

        rangeCheckForAdd(index);
        ensureCapacity(size + 1);

        //若index靠前，则只挪动前一半的元素
        if (index < (size >> 1)) {
            for (int i = 0; i < index; i++) {
                //index(-1) == -1 + capacity
                elements[index(i - 1)] = elements[index(i)];
            }
            front--;
        } else {
            //index靠后，则将后面的元素往后挪动
            for (int i = size - 1; i >= index; i--) {
                elements[index(i + 1)] = elements[index(i)];
            }
        }
        elements[index(index)] = element;
        size++;
    }

    /**
     * O(size * (O(1) || O(size >> 1))) = O(size) || O(1 / 2)size ^ 2 = O(n) || O(n^2)
     * 元素本身没有顺序，不清楚怎么优化
     *
     * @param element
     * @return
     */
    @Override
    public boolean remove(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
        /*int index = indexOf(element);
        if (index > 0){
            remove(index);
            return true;
        }
        return false;*/
    }

    /**
     * @param
     * @return
     * @Description O(1) || O(size >> 1)
     * @date 2020/12/22
     */
    @Override
    public E remove(int index) {

        rangeCheck(index);
        E old = elements[index];
        //若index靠前，只需要将其前面的元素往后挪动
        if (index < (size >> 1)) {
            for (int i = index - 1; i >= 0; i--) {
                elements[index(i + 1)] = elements[index(i)];
            }
            elements[front] = null;
            front++;
        } else {
            //若index靠后，只需要将其后面的元素往前挪动
            for (int i = index + 1; i < size; i++) {
                elements[index(i - 1)] = elements[index(i)];
            }
            elements[index(size - 1)] = null;
        }
        size--;
        trim(size);
        return old;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public E set(int index, E element) {

        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;

        return old;
    }

    /**
     * O(n)
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {

        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUNT;
    }


    /**
     * @param
     * @return
     * @Description 清空 O(size)
     * @date 2020/12/22
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        front = 0;
        size = 0;
    }


    /**
     * @param
     * @return
     * @Description 从头部出队 O(1)
     * @date 2020/12/22
     */
    public E deQueueFront() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    /**
     * @param element
     * @return
     * @Description 头部入队 O(1)
     * @date 2020/12/22
     */
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;
    }

    /**
     * @param element
     * @return
     * @Description 尾部入队 O(1)
     * @date 2020/12/22
     */
    /*public void enQueueRear(E element) {
        ensureCapacity(size + 1);

        elements[index(size)] = element;
        size++;
    }*/
    /**
     * @param
     * @return 尾部坐标
     * @Description 尾部出队
     * @date 2020/12/22
     */
    /*public E deQueueRear() {
        int rearIndex = index(size - 1);
        E rear = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return rear;
    }*/

    /**
     * @param
     * @return
     * @Description 头部元素
     * @date 2020/12/22
     */
    public E front() {
        return elements[front];
    }

    /**
     * @param
     * @return
     * @Description 尾部元素
     * @date 2020/12/22
     */
    public E rear() {
        return elements[index(size - 1)];
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capcacity=").append(elements.length)
                .append(" size=").append(size)
                .append(" front=").append(front)
                .append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }

    /**
     * @param
     * @return
     * @Description 队列真实索引 n >= o,m > 0; n % m 等价于 n - (m > n ? 0 : m) 前提：n < 2m;
     * @date 2020/12/22
     */
    private int index(int index) {
        index += front;
        //元素下标为负数时加上其数组容量
        if (index < 0) {
            return index + elements.length;
        }
//        (front + index) % element.length 优化
        return index - (index >= elements.length ? elements.length : 0);
    }

    /**
     * 保证要有capacity的容量
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            //index(i) 为
            newElements[i] = elements[index(i)];
        }
        elements = newElements;

        // 重置front
        front = 0;
    }

    /**
     * @param
     * @return
     * @Description 缩容
     * @date 2020/12/23
     */
    private void trim(int size) {
        //元素数量小于数组容量一半，缩容
        if (size < (elements.length >> 1)) {
            //缩容为原来的一半
            E[] newElements = (E[]) new Object[elements.length >> 1];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[index(i)];
                elements[index(i)] = null;
            }
            elements = newElements;

            front = 0;
        }
    }

    /**
     * @Description 排序
     * @date 2020/12/23
     * @param
     * @return
     *
     */
    public void sort(Comparator<? super  E> comparator){
        Arrays.sort((E[])elements,0,size,comparator);
    }
}
