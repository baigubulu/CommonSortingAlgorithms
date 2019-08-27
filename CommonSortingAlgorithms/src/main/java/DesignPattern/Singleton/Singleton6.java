package DesignPattern.Singleton;

//该方式使用的比较少
public class Singleton6 {
    //双重校验的模式
    private volatile static Singleton6 instance;

    private Singleton6() {
    }

    /**
     * 使用两次判空操作，线程安全，并且可以保证数据的准确性
     *
     * @return
     */
    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
