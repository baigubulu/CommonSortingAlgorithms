package ReflectDemo;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo02 {
    /**
     * 获取对象的实例，并操作对象
     */
    public static void demo07() {
        Class perClazz = null;
        try {
            perClazz = Class.forName("ReflectDemo.Person");
//            Object newInstance =  perClazz.newInstance();
//            //将创建的对象强转
//            Person per = (Person)newInstance;
            //上面两句代码和下面这句实现的是相同的意思
            Person per = (Person)perClazz.newInstance();
            per.setAge(1);
            per.setId(1);
            System.out.println(per.getAge() + "," + per.getId());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 控制方法和属性
     */
    public static void demo08() {
        Class perClazz = null;
        try {
            perClazz = Class.forName("ReflectDemo.Person");
            Object newInstance =  perClazz.newInstance();
            Person per = (Person)newInstance;
            Field idField = perClazz.getDeclaredField("id");
            Field ageField = perClazz.getDeclaredField("age");

            /**
             * 相当于per.setId(1)，单不是该方法
             * 访问的是private修饰的id，但是private 是私有的
             * 解决方案：修改访问权限 -- 修饰符限制，使用函数为：setAccessible -- Method 和 Field都有该方法
             */
            idField.setAccessible(true);
            ageField.setAccessible(true);
            idField.set(per, 1);
            ageField.set(per, 1);
            System.out.println(per.getAge() + "," + per.getId());
            System.out.println("===========");

            //无参方法的场景
            Method methods = perClazz.getDeclaredMethod("privateMethod", null);
            methods.setAccessible(true);
            methods.invoke(per, null);

            //有参方法的场景,并且是多参数的形式
            Class<?>[] classes = {String.class, Integer.class};
            Method method = perClazz.getDeclaredMethod("privateMethod", classes);
            method.setAccessible(true);
            //传入的参数值为wangyu, string 类型
            method.invoke(per, "wangyu");

            //构造方法的场景
            Constructor constructors = perClazz.getConstructor(int.class);
            System.out.println(constructors);

            //获取到构造方法之后，就可以继续获取到对象了
            Object instance = constructors.newInstance(1);
            Person person = (Person) instance;
            person.setId(1);
            System.out.println(person.getId());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReflectDemo02.demo07();
        ReflectDemo02.demo08();
    }
}
