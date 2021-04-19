package main.java.day01.com.bjpowernode.array;

/**
 * @author feng
 * @date 2020/12/18
 * @Description
 */

public class ArrayList<E> {

    //元素的数量
    private int size;

    //所有元素
    private E[] elements;

    //
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(int capaticy) {
        //capatic 如果小于 DEFAULT_CAPACITY，则返回DEFAULT_CAPACITY
        capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
        //新建一个长度为capaticy的数组
        elements = (E[]) new Object[capaticy];
    }

    //  使用此空参构造器会创建一个长度为10的数组
    public ArrayList() {
        //this(),调用空参构造器
        this(DEFAULT_CAPACITY);
    }

    //清除所有元素
    public void clear() {
        for (int i = 0; i < size; i++) {
            //能循环利用的留下，不能循环利用的滚蛋，把在堆内存中的地址值赋值为null时（全部清空），
            // 没有引用指向对象，则等待垃圾回收器回收
            elements[i] = null;

        }
        //将0赋值给size，用户在调用方法给出数据不存在的假象，
        // 其实数据在内存中依然存在，在此添加则会从第一个元素开始覆盖原来的数据，size++；
        size = 0;
    }

    //元素的数量
    public int size() {
        return size;
    }

    //是否为空
    public boolean isEmpty() {
//        if(size == 0){
//            return true;
//        }else{
//            return false;
//        }

        return size == 0;
    }

    //是否包含某个元素
    public boolean contains(E element) {
        //调用方法indexOf
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    //添加元素到尾部
    public void add(E element) {/* 时间复杂度： 最好是在尾部添加，即最好O(1),
    最坏需要扩容,扩容完毕要挪动所有的元素到新数组,即最坏O(n)
    平均复杂度 ：O(1),相对来讲添加元素绝大多数时间复杂度为O(1),很少会取扩容
    均摊复杂度：O(1)经过连续的多次复杂度比较低的情况后，出现个别复杂度比较高的情况 */
//        elements[size] = element;
//        size ++;

//          当加一个元素后size自加一
//        elements[size++] = element;

        add(size, element);
    }

    //获取index位置的元素
    public E get(int index) {
        rangeCheck(index);

        return elements[index];/*时间复杂度O(1)，因为数组的随机访问速度飞快，
        不管是访问最后一个元素还是第一个元素，在编译期会快速计算出该位置上的索引，
        比如int类型数组计算地址值公式大概是这样：数组首地址 + index * 4  */
    }

    //set index 位置的元素
    public E set(int index, E element) {/*时间复杂度O(1)原理同上*/
        //调用已封装好的方法，范围检查操作
        rangeCheck(index);
        //取出原来位置上的元素
        E old = elements[index];
        //用新元素将原来的元素覆盖
        elements[index] = element;
        //返回原来的元素（这个元素可能有用）,可以不接收
        return old;
    }

    //在index位置插入元素
    public void add(int index, E element) {/*时间复杂度：size是数据规模，最好情况是添加到尾部，最好为O(1),
    最坏是添加到首位置，最坏为O(size)即O(n),
    取平均值（1 + 2 + 3 + ... + n)/n = (1 + n) * n / 2 / n = (n + 1)/2  去掉系数后即平均复杂度为O(n) */
//        调用以封装好的方法
        rangeCheckForAdd(index);

        //调用方法（保证容量）
        ensureCapacity(size + 1);
//
        //相对以下循环的优化（同时加一，循环次数不变）
        for (int i = size; i > index; i--) {
//        for (int i = size - 1; i >= index; i--) {
            //错误写法elements[i] = elements[i -1]，
            // 将最后一位元素（下标为size -1）向右覆盖一位
//            用循环将index后面的元素统一右移一位
            elements[i + 1] = elements[i];
        }
//        将要添加的元素覆盖在下标为index的位置上
        elements[index] = element;
        //切记size + 1;
        size++;
    }

    //删除index位置的元素
    public E remove(int index) {/*时间复杂度：同add(int index E element)  */
//        调用私有方法（只能在本类调用）已封装好的
        rangeCheck(index);
//        将要删除的值
        E old = elements[index];
//        去除index位置元素，将index后边的元素统一向左平移
        for (int i = index + 1; i < size; i++) {
//            平移的方法就是将index后边的元素挨个往前覆盖原来的值
            elements[i - 1] = elements[i];

        }
        //切记size -1;
//        size--;

        //先size--；
//        size --;
        //在把最后位置上的元素赋值为空,不赋值为空则该位置上的元素依然存在，
        // 如果只进行size--控制台只会显示前面的元素，但并不意味这末元素不存在
//        elements[size] = null;
        elements[--size] = null;
        //缩容判断
        trim();
        //返回删除的值
        return old;
    }

    //查看某元素的索引
    public int indexOf(E element) {
//      对element进行非空判断
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
            //如果有一个元素的值与输入的元素一致，返回下标
//            if (elements[i] == element) return i;
        }
        //如果有一个元素的值与输入的元素不一致，返回-1；
        return ELEMENT_NOT_FOUND;
    }

    //保证要有capacity的容量即capacity的值为（size + 1）
    private void ensureCapacity(int capacity) {/*时间复杂度：扩容完毕要挪动所有的元素到新数组，即O(n)*/
        //将elements.length（即10）赋给oldCapacity
        int oldCapacity = elements.length;
        //如果capacity(size + 1) 小于等于 elements.length(即10),则停止该方法
        if (oldCapacity >= capacity) {
            return;
        }
        //程序执行到这里，说明（size+1）> elements.length(即10)，
        // 进行扩容，创建新的数组，长度为原来的1.5倍,位移运算符效率较高
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        //采用循环将原来数组里的元素挨个赋值给新的数组
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];

        }
        //
        System.out.println(oldCapacity + "扩容为" + newCapacity);
        //将新数组里的元素赋值给原来的
        elements = newElements;
    }

    //  缩容
    private void trim() {
        int Oldapacity = elements.length;
        int newCapacity = Oldapacity >> 1;
//        设置满足以下条件不需要缩容
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

    private void outOfBounds(int index) {
        throw new ArrayIndexOutOfBoundsException("Index:" + index + ",Size" + size);

    }

    //数组角标越界异常
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    //数组角标越界异常
    public void rangeCheckForAdd(int index) {
        //这里的index可以等于size
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

      @Override
//    自动生成
//    public String toString() {
//        return "ArrayList{" +
//                "size=" + size +
//                ", elements=" + Arrays.toString(elements) +
//                '}';
//    }
//    手动实现
    public String toString() {
//      StringBuilder线程不安全但效率高
        StringBuilder string = new StringBuilder();
        string.append("size = ").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            //元素前面加，i ！= 0；表示第一个元素不加逗号
            if (i != 0) {
                string.append(",");
            }
            string.append(elements[i]);
//              元素后面加逗号（最后一个不加逗号），相对上面需要进行-1运算
//            if(i != size -1){
//                string.append(",");
//            }
        }
        string.append("]");
        return string.toString();
    }
}

