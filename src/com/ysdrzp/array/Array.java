package com.ysdrzp.array;

/**
 * 二次封装数组
 * @author 翟志鹏
 */
public class Array<E> {

    /**
     * 数组中的元素个数： size可以理解为数组中第一个没有元素的位置索引大小
     */
    private int size;

    /**
     * 数据
     */
    private E[] data;

    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    /**
     * 获取数组元素个数
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 将数组空间的容量变成 newCapacity 大小
     */
    public void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 指定索引位置插入元素
     * @param index
     * @param element
     */
    public void addElement(int index, E element){

        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        // 扩容
        if (size == data.length){
            resize(data.length * 2);
        }

        for (int i = size; i > index; i--){
            data[i] = data[i-1];
        }
        data[index] = element;
        size++;
    }

    /**
     * 末尾添加元素
     * @param element
     * @return
     */
    public void addLast(E element){
        addElement(size, element);
    }

    /**
     * 首位添加元素
     * @param element
     * @return
     */
    public void addFirst(E element){
        addElement(0, element);
    }

    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");

        return data[index];
    }

    /**
     * 获取末尾元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 获取首位元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 修改指定索引位置元素
     * @param index
     * @param element
     * @return
     */
    public void set(int index, E element){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }

        data[index] = element;
    }

    /**
     * 查找数组中元素element所在的索引，如果不存在元素element，则返回-1
     * @param element
     * @return 返回元素索引位置
     */
    public int find(E element){
        for (int i = 0; i < size; i++){
            if (data[i] == element){
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找数组中是否有元素element
     * @param element
     * @return
     */
    public boolean contains(E element){
        int index = find(element);
        if (index >= 0){
            return true;
        }
        return false;
    }

    /**
     * 删除指定索引位置的元素
     * @param index
     * @return 返回删除元素
     */
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        if (size == 0){
            throw new IllegalArgumentException("Array is Empty");
        }

        E element = data[index];

        for (int i = index; i < size-1; i++){
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;

        // 缩容，防止复杂度震荡
        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return element;
    }

    /**
     * 删除末尾元素
     * @return 返回删除元素
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 删除首位元素
     * @return 返回删除元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除指定元素
     * @param element
     * @return
     */
    public void removeElement(E element){
        int index = find(element);
        if (index >= 0){
            remove(index);
        }
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("size = %d,capacity = %d\n", size, data.length));
        stringBuilder.append("[");
        for (int i = 0; i < size; i++){
            stringBuilder.append(data[i]);
            if (i != size - 1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
