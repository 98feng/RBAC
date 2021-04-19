package day01.com.bjpowernode.homework02;

import java.util.Comparator;

/**
 * @author feng
 * @date 2020/12/18
 * @Description 公司 公司中有若干的员工, 使用数组来保存员工信息
 * 提供方法, 添加员工
 * 提供方法,显示所有员工信息
 * 提供方法, 查找是否存在指定姓名的员工
 * 提供方法,删除指定姓名的员工
 */

@SuppressWarnings("unchecked")
public class Company<E> {
    /**
     * 元素的数量
     */
    private int size;

    /**
     * 所有元素
     */
    private E[] elements;


    private Comparator<E> comparator;


    public Company(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    private static final int DEFAULT_CAPACITY = 100;
    private static final int ELEMENT_NOT_FOUND = -1;

    public Company(int capaticy) {

        capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
        elements = (E[]) new Object[capaticy];
    }

    public Company() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * @param
     * @return
     * @Description 元素的数量
     * @date 2020/12/18
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;

        }
        size = 0;
    }

    /**
     * @param
     * @return size
     * @Description 元素的数量
     * @date 2020/12/18
     */
    public int size() {
        return size;
    }

    /**
     * @param
     * @return
     * @Description 是否为空
     * @date 2020/12/18
     */
    public boolean isEmpty() {


        return size == 0;
    }

    /**
     * @param element
     * @return 包含返回true，不包含返回false
     * @Description 是否包含某个元素
     * @date 2020/12/18
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * @param element
     * @return
     * @Description 添加元素到尾部
     * @date 2020/12/18
     */
    public void add(E element) {/* 时间复杂度： 最好是在尾部添加，即最好O(1),
    最坏需要扩容,扩容完毕要挪动所有的元素到新数组,即最坏O(n)
    平均复杂度 ：O(1),相对来讲添加元素绝大多数时间复杂度为O(1),很少会取扩容
    均摊复杂度：O(1)经过连续的多次复杂度比较低的情况后，出现个别复杂度比较高的情况 */


        add(size, element);
    }

    /**
     * @param index
     * @return 该位置上的元素
     * @Description 获取index位置的元素
     * @date 2020/12/18
     */
    public E get(int index) {
        rangeCheck(index);

        return elements[index];/*时间复杂度O(1)，因为数组的随机访问速度飞快，
        不管是访问最后一个元素还是第一个元素，在编译期会快速计算出该位置上的索引，
        比如int类型数组计算地址值公式大概是这样：数组首地址 + index * 4  */
    }

    /**
     * @param index
     * @return 还没有被覆盖的元素old
     * @Description 覆盖 index 位置的元素
     * @date 2020/12/18
     */
    public E set(int index, E element) {/*时间复杂度O(1)原理同上*/

        rangeCheck(index);
        //覆盖之前保存可能有用的值
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * @param index element 在某个位置添加元素
     * @return
     * @Description 在index位置插入元素
     * @date 2020/12/18
     */
    public void add(int index, E element) {/*时间复杂度：size是数据规模，最好情况是添加到尾部，最好为O(1),
    最坏是添加到首位置，最坏为O(size)即O(n),
    取平均值（1 + 2 + 3 + ... + n)/n = (1 + n) * n / 2 / n = (n + 1)/2  去掉系数后即平均复杂度为O(n) */
        rangeCheckForAdd(index);

        //调用方法（保证容量）
        ensureCapacity(size + 1);

        // System.arraycopy(element, index, element, index + 1,
        //                         size - index);

        for (int i = size; i > index; i--) {

            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {/*时间复杂度：同add(int index E element)  */
        rangeCheck(index);
        E old = elements[index];
        //System.arraycopy(element, index + 1, element, index, size - index - 1);
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];

        }

        elements[--size] = null;
        //缩容判断
        trim();
        return old;
    }

    /**
     * @param element
     * @return 找到返回对应的下标，没找到返回ELEMENT_NOT_FOUND
     * @Description 查看某元素的索引
     * @date 2020/12/18
     */
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
        return ELEMENT_NOT_FOUND;
    }

    private void ensureCapacity(int capacity) {/*时间复杂度：扩容完毕要挪动所有的元素到新数组，即O(n)*/
        //将elements.length赋给oldCapacity
        int oldCapacity = elements.length;
        //如果capacity(size + 1) 小于等于 elements.length,则停止该方法
        if (oldCapacity >= capacity) {
            return;
        }
        // 进行扩容，创建新的数组，长度为原来的1.5倍,位移运算符效率较高
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];

        }
        System.out.println(oldCapacity + "扩容为" + newCapacity);
        elements = newElements;
    }

    /**
     * @param
     * @return
     * @Description 缩容
     * @date 2020/12/18
     */
    private void trim() {
        int Oldapacity = elements.length;
        int newCapacity = Oldapacity >> 1;
        if (size >= newCapacity || Oldapacity <= DEFAULT_CAPACITY) {
            return;
        }

        //剩余空间还有很多
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(Oldapacity + "缩容为" + newCapacity);
    }
 /*注意：扩容和缩容倍数相乘不要等于1，不然会进行复杂度震荡,本来时间复杂度为O(1),
 突然变为O(n)且一直处于扩容和缩容状态，不会有最好情况，
 例如添加末元素扩容为2倍，删除这个元素又缩容为1/2，反复扩容和缩容导致时间复杂度始终为O(n) */

    /**
     * @param index
     * @return
     * @Description 数组角标越界异常
     * @date 2020/12/18
     */
    private void outOfBounds(int index) {
        throw new ArrayIndexOutOfBoundsException("Index:" + index + ",Size" + size);

    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    public void rangeCheckForAdd(int index) {
        //这里的index可以等于size
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    /*public String toString() {
        return "ArrayList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }*/

    /**
     * @param
     * @return java.lang.String
     * @Description toString
     * @date 2020/12/18
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size = ").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            //元素前面加，i ！= 0；表示第一个元素不加逗号
            if (i != 0) {
                string.append("," + "\n");
            }
            string.append(elements[i]);

        }
        string.append("]");
        return string.toString();
    }

    /**
     * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

}





