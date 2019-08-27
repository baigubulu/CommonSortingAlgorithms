package DesignPattern.Singleton;

/**
 * 饿汉模式，线程安全(对象)
 */
public class Singleton3 {

    private static Singleton3 instance = null;
    private Singleton3(){}

    public static Singleton3 getInstance(){
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
