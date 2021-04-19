package day02.com.bjpowerndoe.homowork01.circleArrayQueue;

import java.util.Iterator;
import java.util.Spliterator;

/**
 * @author feng
 * @date 2020/12/20
 * @Description
 */
public abstract class AbstractList<E> implements List<E> {
    protected int size;
    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        add(size,element);
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUNT;
    }

    protected void outOfBounds(int index){
        throw new IndexOutOfBoundsException("index:" + index + "size" + size);
    }

    protected void rangeCheck(int index){
        if (index < 0 || index >= size){
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            outOfBounds(index);
        }
    }

}

