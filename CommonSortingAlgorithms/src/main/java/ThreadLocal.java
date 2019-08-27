import DesignPattern.Singleton.Singleton1;

import java.net.StandardSocketOptions;
import java.util.concurrent.CountDownLatch;

public class ThreadLocal {

    public static void main(String args) throws Exception{
        long startTime = System.currentTimeMillis();

        int threadNum = 10;
        //加入锁的概念，参数为线程的数量
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        //启动10个线程，每个线程内部执行1000000创建实例的方法
        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i< 1000000; i++) {
                        Object object = Singleton1.getInstance();
                    }
                    //释放这个所，相当于计数器减1的操作
                    countDownLatch.countDown();
                }
            }).start();

            //放一个阻塞，就相当于是循环检测 - while
            //main函数线程阻塞，直到计数器变为0，才会继续往下执行
            countDownLatch.await();

            long endTime = System.currentTimeMillis();
            System.out.println("总耗时：" + (endTime - startTime));
        }
    }
}
