package java.aop.imple;

import java.aop.Service;

public class ServiceImpl implements Service {

    @Override
    public void add() {
        System.out.println("AService add>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void update() {
        System.out.println("AService update>>>>>>>>>>>>>>>");
    }
}
