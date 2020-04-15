package com.ysdrzp.array;

/**
 * 二次封装数组
 * @author 翟志鹏
 */
public class Array {

    private int size;

    private int[] data;

    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    public Array(){
        this.data = new int[10];
    }

    /**
     * 指定索引位置插入元素
     * @param index
     * @param element
     */
    public void addElement(int index, int element){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("参数非法");
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
    public boolean addLast(int element){
        addElement(size, element);
        return true;
    }

    /**
     * 首位添加元素
     * @param element
     * @return
     */
    public boolean addFirst(int element){
        addElement(0, element);
        return true;
    }

    /**
     * 删除指定索引位置的元素
     * @param index
     * @return
     */
    public boolean remove(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("参数非法");
        }

        if (size == 0){
            throw new IllegalArgumentException("Array is Empty");
        }

        for (int i = index; i < size-1; i++){
            data[i] = data[i + 1];
        }

        size--;
        return true;
    }

    /**
     * 删除末尾元素
     * @return
     */
    public int removeLast(){
        this.remove(size-1);
        return data[size-1];
    }

    /**
     * 删除首位元素
     * @return
     */
    public int removeFirst(){
        this.remove(0);
        return data[0];
    }

    /**
     * 查找元素
     * @param element
     * @return 返回元素索引
     */
    public int find(int element){
        for (int i = 0; i < size; i++){
            if (data[i] == element){
                return i;
            }
        }
        return -1;
    }

    /**
     * 修改元素
     * @param index
     * @param element
     * @return
     */
    public boolean setElment(int index, int element){
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
        int[] newData = new int[data.length * 2];
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

        Array array = new Array(10);
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
        array.addLast(666);
        array.addLast(777);
    }

}
