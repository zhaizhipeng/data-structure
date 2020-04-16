package com.ysdrzp.leetcode;

import com.ysdrzp.stack.ArrayStack;

/**
 * 有效的括号-(LeetCode-20)
 * @author 翟志鹏
 */
public class ValidParentheses {

    public boolean isValid(String str){
        ArrayStack<Character> arrayStack = new ArrayStack<>(10);
        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if ('(' == c || '{' == c || '[' == c) {
                arrayStack.push(c);
                continue;
            }

            if (')' == c && arrayStack.pop() != '('){
                return false;
            }

            if ('}' == c && arrayStack.pop() != '{'){
                return false;
            }

            if (']' == c && arrayStack.pop() != '['){
                return false;
            }

        }

        return arrayStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("{}"));
        System.out.println(new ValidParentheses().isValid("{()}"));
        System.out.println(new ValidParentheses().isValid("{}(]"));
    }
}
