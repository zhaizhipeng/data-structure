package com.ysdrzp.leetcode;

import java.util.Stack;

/**
 * 有效的括号-(LeetCode-20)
 * @author 翟志鹏
 */
public class ValidParentheses {

    public boolean isValid(String str){
        Stack<Character> arrayStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if ('(' == c || '{' == c || '[' == c) {
                arrayStack.push(c);
                continue;
            }

            // 特殊判断
            if (arrayStack.isEmpty()){
                return false;
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
        System.out.println(new ValidParentheses().isValid("{}()]"));
    }
}
