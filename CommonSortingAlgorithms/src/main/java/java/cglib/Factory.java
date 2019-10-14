package java.cglib;

import com.sun.istack.internal.NotNull;
import net.sf.cglib.proxy.Enhancer;

import java.util.Arrays;

/**
 * 获取增强的目标类的工厂Factory，其中增强的方法类对象有Enhancer来实现
 */
public class Factory {


    public static Base getInstance(CglibProxy proxy) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Base.class);
        enhancer.setCallback(proxy);
        Base base = (Base) enhancer.create();

        return base;
    }
}
