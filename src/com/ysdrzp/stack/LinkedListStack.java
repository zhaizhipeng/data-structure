package com.ysdrzp.stack;

import com.ysdrzp.linkedlist.LinkedList;

/**
 * 链表实现栈
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {

    LinkedList<E> linkedList;

    public LinkedListStack(){
        linkedList = new LinkedList();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E element) {
        linkedList.addFirst(element);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(linkedList);
        return res.toString();
    }
}
