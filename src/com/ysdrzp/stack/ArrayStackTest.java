package com.ysdrzp.stack;

public class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(10);
        for (int i = 0; i < 11; i++){
            arrayStack.push(i);
        }
        System.out.println(arrayStack);
    }
}
