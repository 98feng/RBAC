package main.java.day01.com.bjpowernode.array;

/**
 * @author feng
 * @date 2020/12/18
 * @Description 扩容
 */
public class Array<E> {

    //元素的数量
    private int size;

    //所有元素
    private E[] elements;

    private static final int DEFALUT_CAPACITY = 10;

    public Array(int capaticy) {
        capaticy = (capaticy < DEFALUT_CAPACITY) ? DEFALUT_CAPACITY : capaticy;
        elements = (E[]) new Object[capaticy];
    }

    public Array() {
        this(DEFALUT_CAPACITY);
    }

    public void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }

        int newCapacty = oldCapacity + (oldCapacity >> 1);

        E[] newElements = (E[]) new Object[newCapacty];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];

        }
        elements = newElements;

        System.out.println(oldCapacity + "扩容为 " + newCapacty);
    }


    public void add(int index, E element) {

        ensureCapacity(size + 1);

        /*for (int i = size; i > index; i--) {
            elements[i + 1] = elements[i];
        }*/
        System.arraycopy(elements, index, elements, index + 1,
                size - index);
        elements[index] = element;

        size++;
    }

    public E remove(int index){
        E old = elements[index];

        System.arraycopy(elements, index+1, elements, index,
                size - index - 1);
        elements[--size] = null;
        return old;
    }


}
