package DesignPattern.Singleton;

/**
 * 饿汉模式 实现 单例模式,只要获取instance，就会创建Singleton4对象
 * 因为存在static，所以线程安全
 */
public class Singleton4 {

    private static Singleton4 instance = new Singleton4();

    private Singleton4(){}

    public static Singleton4 getInstance(){
        return instance;
    }
}
