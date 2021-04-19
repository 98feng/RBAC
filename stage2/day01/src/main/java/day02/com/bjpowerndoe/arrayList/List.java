package day02.com.bjpowerndoe.arrayList;

/**
 * @author feng
 * @date 2020/12/20
 * @Description
 */
public interface List<E> {
    int ELEMENT_NOT_FOUNT = -1;
    int size();
    boolean isEmpty();
    boolean contains(E element);
    void add(E element);
    void add(int index,E element);
    boolean remove(E element);
    E remove(int index);
    void clear();
    E get(int index);
    E set(int index,E element);
    int indexOf(E element);

}
