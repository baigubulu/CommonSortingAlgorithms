package Fibonacci;

//斐波那契数列实现，主要有两种，一种是递归调用，另外一种是使用循环调用的方
public class FibonacciSequence {

    /**
     * Fibonacci数列实现的方法 -- 递归实现
     * 求出每一项 F(1)=1，F(2)=1, F(3)=2,F(n)=F(n-1)+F(n-2)
     * @param n
     * @return
     */
    public int getFib(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return getFib(n - 1) + getFib(n - 2);
        }
    }

    /**
     * 使用循环方式实现Fibonacci数列
     * @param n
     * @return
     */
    public int getFibLoop(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        //设置三个变量，用来存储中间值
        int a1 = 1;
        int a2 = 1;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum = a1 + a2;
            a1 = a2;
            a2 = sum;
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args){
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        fibonacciSequence.getFibLoop(5);
        int result = fibonacciSequence.getFib(5);
        System.out.println(result);
    }
}
