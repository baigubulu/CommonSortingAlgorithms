package QueueAndStack;

import java.util.Stack;

/**
 * 两个栈生成队列
 */
public class StackToQueue {

    //由栈生成队列
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackToQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //Push element x to the back of queue
    public void push(int num){
        stack1.push(num);
    }

    //pop数据
    public int pop(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    //peek 数据
    public int peek(){
        if (stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    //queue为空
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
