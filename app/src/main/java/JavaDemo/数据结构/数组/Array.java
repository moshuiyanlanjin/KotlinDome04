package JavaDemo.数据结构.数组;

public class Array<E> {

    private E[] data;

    private int size;

    /**
     * 初始化
     *
     * @param capacity 数组空间大小
     */
    public Array(int capacity) {
        data = (E[])(new Object[capacity]);
        size = 0;
    }

    public Array() {
        this(10);
    }

    /**
     * 获取当前数组数据长度
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组长度
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("数据超限");
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("数据超限");
        data[index] = e;
    }

    /**
     * 为数组添加数据
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }


    /**
     * 向数组的头部添加数据
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 为数组指定下标插入数据
     *
     * @param index 需要插入数据的坐标
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("数据错误");

        if (size == data.length)
            resize(data.length * 2);

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }



    /**
     * 判断当前数组是否包含当前元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i] .equals(e) )
                return true;
        }
        return false;
    }

    /**
     * 获取当前元素对应的索引,如果没有此元素，则返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 删除当前数组最后一个元素,并返回删除的元素
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 删除当前数组第一个元素,并返回删除的元素
     */
    public E romoveFirst(){
        return remove(0);
    }

    /**
     * 判断当前数组是否有此元素，如果有则删除
     * @param e
     */
    public void romoveElement(E e){
        int i = find(e);
        if(i != -1)
            remove(i);
    }

    /**
     * 删除数组指定下标的数据,并返回所删除的数据
     * @param index
     */
    public E remove(int index){
      //  System.out.println("当前的两个长度是:" + size + ".." + data.length);
        if (size <= 0)
            throw new IllegalArgumentException("数据超限");

        if (index < 0 || index > size)
            throw new IllegalArgumentException("数据错误");

        E e = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        if(size == data.length/4 && data.length/2 != 0){
          resize(data.length/2);
        }
        return e;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Array:size = %d,list = %d\n", size, data.length));
        str.append("[");
        for (int i = 0; i < size; i++) {
            str.append(data[i]);
            if (i < size - 1)
                str.append(",");
        }
        str.append("]");
        return str.toString();
    }

    /**
     * 扩容、缩容
     * @param newCapacity 容量空间大小
     */
    private void resize(int newCapacity) {
    //    System.out.println("当前的三个长度是:" + size + ".." + data.length + ".." + newCapacity);
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
