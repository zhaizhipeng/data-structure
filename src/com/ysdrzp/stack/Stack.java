package com.ysdrzp.stack;

public interface Stack<E> {

    /**
     * 获取栈内元素个数
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入栈
     * @param element
     */
    void push(E element);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return
     */
    E peek();
}
