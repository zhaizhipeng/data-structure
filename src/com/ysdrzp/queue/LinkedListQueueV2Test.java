package com.ysdrzp.queue;

public class LinkedListQueueV2Test {

    public static void main(String[] args) {
        LinkedListQueueV2<Integer> queue = new LinkedListQueueV2<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
