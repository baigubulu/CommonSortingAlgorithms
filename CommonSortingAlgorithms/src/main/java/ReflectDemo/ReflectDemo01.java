package ReflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo01 {

        /**
         * 获取公共方法(getMethods)和当前该类的所有方法(getDeclaredMethods)
         */
        public static void demo01() {
            Class perClazz = null;

            try {
                //读取person这个类
                perClazz = Class.forName("ReflectDemo.Person");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //获取所有的公共方法(1. 本类以及父类、接口当中的方法 2. 符合访问修饰符规律)
            Method method[] =  perClazz.getMethods();
            for (Method method1 : method) {
                System.out.println(method1);
            }
            System.out.println("获取当前类的所有方法...");
            //获取当前类的所有方法 (1. 只能是当前类  2.忽略访问修饰符限制 )
            Method[] methods =  perClazz.getDeclaredMethods();
            for (Method method1 : methods) {
                System.out.println(method1);
            }
        }

        /**
         * 获取所有的接口(getInterfaces)
         */
        public static void demo02() {
            Class perClazz = null;

            try {
                perClazz = Class.forName("ReflectDemo.Person");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Class[] interfaces =  perClazz.getInterfaces();
            for (Class inter : interfaces) {
                System.out.println(inter);
            }
        }

        /**
         * 获取所有的父类
         */
        public static void demo03() {
            Class perClazz = null;

            try {
                perClazz = Class.forName("ReflectDemo.Person");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Class superClass =  perClazz.getSuperclass();
            System.out.println(superClass);
        }

        /**
         * 获取到所有的构造方法
         */
        public static void demo04() {
            Class perClazz = null;

            try {
                perClazz = Class.forName("ReflectDemo.Person");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Constructor[] constructors =  perClazz.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }
        }

        /**
         * 获取所有的公共属性(getDeclaredFields)
         */
        public static void demo05() {
            Class perClazz = null;

            try {
                perClazz = Class.forName("ReflectDemo.Person");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Field[] fields = perClazz.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            //获取当前类的所有变量 (1. 只能是当前类  2.忽略访问修饰符限制 )
            Field[] fields1 = perClazz.getDeclaredFields();
            for (Field field : fields1) {
                System.out.println(field);
            }
        }

        /**
         * 获取当前放射所代表类(接口)的对象(实例) -- newInstance()
         */
        public static void demo06() {
            Class perClazz = null;

            try {
                perClazz = Class.forName("ReflectDemo.Person");
                Object newInstance =  perClazz.newInstance();
                Person per = (Person)newInstance;
                per.getAge();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public static void main(String args[]) {
            ReflectDemo01.demo01();
            System.out.println("*******==================******");
            ReflectDemo01.demo02();
            System.out.println("*******==================******");
            //打印出的父类,只有object
            ReflectDemo01.demo03();
            System.out.println("*******==================******");
            ReflectDemo01.demo04();
            System.out.println("*******==================******");
            ReflectDemo01.demo05();
        }
}
