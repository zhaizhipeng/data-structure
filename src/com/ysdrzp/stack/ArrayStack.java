package com.ysdrzp.stack;

import com.ysdrzp.array.Array;

/**
 * 顺序栈-数组实现
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E element) {
        array.addLast(element);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("capacity = %d\n", array.getCapacity()));
        stringBuilder.append("Stack [");
        for (int i = 0; i < array.size(); i++){
            stringBuilder.append(i);
            if (i != array.size() - 1)
                stringBuilder.append(", ");
        }
        stringBuilder.append("] top");
        return stringBuilder.toString();
    }

}
