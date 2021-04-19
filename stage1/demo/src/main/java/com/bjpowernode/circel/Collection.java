package com.bjpowernode.circel;

/**
 * @author feng
 * @date 2020/12/23
 * @Description
 */
public interface Collection<E> {
    int ELEMENT_NOT_FOUNT = -1;

    int size();

    boolean isEmpty();

    boolean contains(E element);

    void add(E element);

    void add(int index, E element);

    boolean remove(E element);

    E remove(int index);

    void clear();

    E get(int index);

    E set(int index, E element);

    int indexOf(E element);
}
