package day02.com.bjpowerndoe.array;


/**
 * @author feng
 * @date 2020/12/19
 * @Description
 */
public abstract class AbstractList<E> implements List<E> {

    protected int size;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUNT;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    protected void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:" + index + "," + "size:" + size);
    }

    protected void rangeCheck(int index){
        if (index <0 || index >= size){
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            outOfBounds(index);
        }
    }

}