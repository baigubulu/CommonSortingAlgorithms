package leetcode.MinStack;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目链接：https://leetcode-cn.com/problems/min-stack/
 * 实现一个栈并且实现获取最小值的函数
 */
public class MinStack {
    List<Integer> list = new LinkedList();
    int minNum = Integer.MAX_VALUE;

    public MinStack() {

    }

    /**
     * 将元素推入栈
     * 每一次入栈，为链表添加元素，将添加的元素与minNum进行比较
     * @param x
     */
    public void push(int x) {
        list.add(x);
        if (x < minNum) {
            minNum = x;
        }

    }

    /**
     * 删除栈顶的元素
     * 首先判断链表的最后一个元素是否与minNum值相等，如果相等，从头遍历链表，找出第二小的元素，最后删除链表的最后一个元素
     */
    public void pop(){
        if (minNum == list.get(list.size() - 1)) {
            minNum = Integer.MAX_VALUE;
            // 找出除最后一个元素最小的元素
            for (int i = 0; i < list.size() - 1; i++){
                if (list.get(i) < minNum) {
                    minNum = list.get(i);
                }
            }
        }
        if (list.size() != 0) {
            list.remove(list.size() - 1);
        }
    }

    /**
     * 获取栈顶的元素
     * @return
     */
    public int top() {
        return list.get(list.size() - 1);
    }

    /**
     * 检索栈中的最小元素
     * @return
     */
    public int getMin() {
        return minNum;
    }
}
