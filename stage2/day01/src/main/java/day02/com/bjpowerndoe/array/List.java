package day02.com.bjpowerndoe.array;

/**
 * @author feng
 * @date 2020/12/19
 * @Description
 */
public interface List<E> {
    int ELEMENT_NOT_FOUNT = -1;

    void clear();

    int size();

    boolean isEmpty();

    boolean contains(E element);

    void add(E element);

    E get(int idnex);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    int indexOf(E element);
}
