package java.aop;

import java.aop.imple.ServiceImpl;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        ServiceImpl service = new ServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(service);
        // Proxy.newProxyInstance实现类动态创建一个符合某一接口的代理示例
        Service serviceProxy = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), handler);
        serviceProxy.add();
        System.out.println();
        serviceProxy.update();
    }
}
