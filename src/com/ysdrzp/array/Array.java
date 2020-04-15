package com.ysdrzp.array;

import java.util.Objects;

/**
 * 二次封装数组
 * @author 翟志鹏
 */
public class Array<E> {

    private int size;

    private E[] data;

    public Array(int capacity){
        data = (E[]) new Objects[capacity];
        size = 0;
    }

    public Array(){
        this.data = (E[]) new Objects[10];
    }

    /**
     * 指定索引位置插入元素
     * @param index
     * @param element
     */
    public void addElement(int index, E element){
        // 保证数组连续性
        if (index < 0 || index > size){
            throw new IllegalArgumentException("参数非法");
        }

        // 触发扩容
        if (size == data.length){
            resize();
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
    public boolean addLast(E element){
        addElement(size, element);
        return true;
    }

    /**
     * 首位添加元素
     * @param element
     * @return
     */
    public boolean addFirst(E element){
        addElement(0, element);
        return true;
    }

    /**
     * 删除指定索引位置的元素
     * @param index
     * @return 返回删除元素
     */
    public E remove(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("参数非法");
        }

        if (size == 0){
            throw new IllegalArgumentException("Array is Empty");
        }

        E element = data[index];

        for (int i = index; i < size-1; i++){
            data[i] = data[i + 1];
        }
        size--;
        return element;
    }

    /**
     * 删除指定元素
     * @param element
     * @return
     */
    public boolean removeElement(E element){
        int index = find(element);
        if (index == -1){
            return false;
        }
        remove(index);
        return true;
    }

    /**
     * 删除末尾元素
     * @return 返回删除元素
     */
    public E removeLast(){
        this.remove(size-1);
        return data[size-1];
    }

    /**
     * 删除首位元素
     * @return 返回删除元素
     */
    public E removeFirst(){
        this.remove(0);
        return data[0];
    }

    /**
     * 查找指定元素
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
     * 修改指定索引位置元素
     * @param index
     * @param element
     * @return
     */
    public boolean setElement(int index, E element){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("参数非法");
        }
        data[index] = element;
        return true;
    }

    /**
     * 2倍扩容
     */
    public void resize(){
        E[] newData = (E[]) new Objects[data.length * 2];
        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
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

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[" + String.format("size = %d,capacity = %d\n", size, data.length));
        for (int i = 0; i < size; i++){
            stringBuilder.append(data[i]);
            if (i != size - 1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        Array<Integer> array = new Array<>(10);
        System.out.println(array);

        for (int i = 0; i < 5; i++){
            array.addLast(i);
        }
        System.out.println(array);

        array.addElement(0,100);
        System.out.println(array);

        array.addFirst(200);
        System.out.println(array);

        System.out.println(array.removeLast());
        System.out.println(array);

        System.out.println(array.removeFirst());
        System.out.println(array);

        System.out.println(array.remove(2));
        System.out.println(array);

        array.addLast(111);
        array.addLast(222);
        array.addLast(333);
        array.addLast(444);
        array.addLast(555);
        System.out.println(array);
        array.addLast(666);
        array.addLast(777);
        System.out.println(array);
    }

}
