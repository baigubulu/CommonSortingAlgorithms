package DesignPattern.Singleton;

/**
 * 懒汉模式,线程安全(类)
 * 线程安全的原因：synchronized关键字
 */
public class Singleton2 {

    private static Singleton2 instance = null;
    private Singleton2(){}

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
