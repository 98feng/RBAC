package com.bjpowernode.arrayList;


/**
 * @author feng
 * @date 2020/12/20
 * @Description
 */
@SuppressWarnings("unchecked")
public class ArrayList<E> extends AbstractList<E> {


    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }


    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //确保容量能装下添加后元素的个数
        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    private void ensureCapacity(int capacity) {

        int oldCapacity = elements.length;
        if (capacity < oldCapacity) {
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;

    }


    private void trim(int capacity) {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity >> 1;
        E[] newElements = (E[]) new Object[newCapacity];

        if (oldCapacity < DEFAULT_CAPACITY || newCapacity < capacity) {
            return;
        }

        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

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
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        trim(size);
        return old;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }

        if (elements != null && elements.length > DEFAULT_CAPACITY) {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }

        size = 0;
    }
    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUNT;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size：").append(size).append("[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();

    }
}
