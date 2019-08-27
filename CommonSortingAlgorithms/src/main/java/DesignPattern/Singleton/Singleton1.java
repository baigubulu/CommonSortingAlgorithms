package DesignPattern.Singleton;
/**
 * 常见单例模式实现 -- 懒汉模式
 * 现在这种实现方法不是线程安全
 */
public class Singleton1 {

    //最简单的单例模式
    private static Singleton1 instance = null;
    //构造方法私有化
    private Singleton1(){}

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
