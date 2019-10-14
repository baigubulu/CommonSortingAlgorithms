package java.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    /**
     * 完成切面逻辑的加入，目标类方法的实现是有method.invoke(target, args);这条语句实现
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Exception
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws  Exception{
        System.out.println("before-----------------------------");
        Object result = method.invoke(target, args);
        System.out.println("after------------------------------");
        return result;
    }
}
