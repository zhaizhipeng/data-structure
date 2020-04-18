package com.ysdrzp.queue;

public class LoopQueueTest {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue();
        for (int i = 0; i < 10; i++){
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }

        arrayQueue.enqueue(100);
        System.out.println(arrayQueue);

        for (int i = 0; i < 10; i++){
            arrayQueue.dequeue();
            System.out.println(arrayQueue);
        }
    }

}
