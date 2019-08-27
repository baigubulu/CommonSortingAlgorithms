package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 两个队列生成栈 -- 队列先进先出，栈先进后出
 * 借鉴文档：https://blog.csdn.net/nsjlive/article/details/82632605
 */
public class QueueToStack {

    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    //压入栈的过程
    public void push(Integer element) {

        if (queue1.isEmpty() && queue2.isEmpty()){
            queue1.add(element);
            return;
        }

        if (queue1.isEmpty()){
            queue2.add(element);
            return;
        }

        if (queue2.isEmpty()){
            queue1.add(element);
            return;
        }
    }

    //弹出栈的过程
    public Integer pop(){
        if (queue1.isEmpty() && queue2.isEmpty()){
            try{
                throw new Exception("stack is null");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        if (queue1.isEmpty()){
            while(queue2.size() > 1){
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }

        if (queue2.isEmpty()){
            if (queue1.size() > 1){
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }

        return (Integer)null;
    }

    //判断入栈是否为空
    public Boolean isEmpty(){
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }

}
