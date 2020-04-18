package com.ysdrzp.queue;

import com.ysdrzp.linkedlist.LinkedList;

/**
 * 链表实现队列-入队的时间复杂度是 O(n)
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E>{

    LinkedList<E> linkedList;

    public LinkedListQueue(){
        linkedList = new LinkedList<>();
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
    public void enqueue(E e) {
        linkedList.addLast(e);
    }

    @Override
    public E dequeue() {
        return linkedList.removeFirst();
    }

}
