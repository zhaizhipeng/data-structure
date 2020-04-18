package com.ysdrzp.linkedlist;

/**
 * 链表
 * @param <E>
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    /**
     * 哨兵节点
     */
    private Node dummyHead;
    /**
     * 链表中的元素个数
     */
    private int size;

    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 获取链表中元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在链表的index位置添加新的元素e
     * 在链表中不是一个常用的操作，练习用
     */
    public void add(int index, E e){

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 在链表头添加元素
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 在链表尾添加元素
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 获得链表的第index个位置的元素
     * 在链表中不是一个常用的操作，练习用
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }

        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 修改链表的第index个位置的元素为e
     * 在链表中不是一个常用的操作，练习用
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;

        for (int i = 0; i < size; i++){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除index位置的元素，返回删除的元素
     * 在链表中不是一个常用的操作，练习用
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++){// 定位到要删除节点的位置
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    /**
     * 从链表中删除第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素，返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 从链表中删除元素e
     * @param e
     */
    public void remove(E e){

        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if (prev.next != null){// 找到要删除的节点
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
