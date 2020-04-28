package com.xzq.剑指offer._31_栈的压入弹出序列;

import java.util.Stack;
import java.util.logging.Level;

/**
 * @ClassName: StackPushPopOrder
 * @description: 面试题31: 栈的压入弹出序列
 * @author: XZQ
 * @create: 2020/4/28 14:24
 * 题目
 * 　　输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1、2、3、4、5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，
 * 但4、3、5、1、2就不可能是该压栈序列的弹出序列。
 **/
public class StackPushPopOrder {
    Stack<Integer> stack = new Stack<>();

    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null)
            return false;
        if (pushA.length != popA.length)
            return false;

        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
//        int[] popA = {4, 3, 5, 1, 2};
        int[] popA = {4, 5, 3, 2, 1};
//        int[] popA = {5, 4, 3, 2, 1};
        System.out.println(new StackPushPopOrder().isPopOrder(pushA, popA));
    }
}
