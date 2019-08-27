package DesignPattern.Singleton;

import DesignPattern.Singleton.Singleton1;

public class Test {
    public static void main(String[] args){
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton1Copy = singleton1;
        System.out.println("singleton1.hashCode:" + singleton1.hashCode());
        System.out.println("singleton1Copy.hashCode:" + singleton1Copy.hashCode());
        System.out.println(singleton1.equals(singleton1Copy));
    }
}
