package com.ysdrzp.queue;

public interface Queue<E> {

    /**
     * 获取队列元素个数
     * @return
     */
    int getSize();

    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();
}
