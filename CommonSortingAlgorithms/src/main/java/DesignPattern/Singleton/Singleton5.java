package DesignPattern.Singleton;

/**
 * 内部静态类实现
 * 优点：全局静态成员放在内部类，之后该内部类被引用时才能实例化，以达到延迟实例化的目的，这个方法的好处是不受jdk的版本影响，并且无需加锁而且性能好，可以确保延迟实例化值getInstance()的调用.
 * 在过程当中，不存在lazy-loading的过程
 */
public class Singleton5 {
    //自由化的构造方法
    private Singleton5(){}

    //保证了线程安全 -- 使用了内部类
    private static class SinglonHolder{
        private final static Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance(){
        return SinglonHolder.instance;
    }
}
