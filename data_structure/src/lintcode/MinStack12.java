package lintcode;

import java.util.Stack;

/**
 * 实现一个栈, 支持以下操作:
 * push(val) 将 val 压入栈
 * pop() 将栈顶元素弹出, 并返回这个弹出的元素
 * min() 返回栈中元素的最小值
 * 要求 O(1) 开销.
 * 样例
 * 样例 2:
 * 输入:
 *   push(1)
 *   min()
 *   push(2)
 *   min()
 *   push(3)
 *   min()
 * 输出:
 *   1
 *   1
 *   1
 * 注意事项
 * 保证栈中没有数字时不会调用 min()
 * @author: bxguo
 * @time: 2019/8/1 15:25
 */
public class MinStack12 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack12() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }

}
