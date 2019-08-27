package ReflectDemo;

public class Person implements MyInterface, MyInterface2 {
    private int id;
    private int age;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //无参构造方法
    public Person(){

    }

    //有参构造函数
    public Person(int id) {
        this.id = id;
    }

    public Person(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    //静态方法
    public static void staticMethod() {
        System.out.println("static method ....");
    }

    //私有方法
    private void privateMethod() {
        System.out.println("private method ....");
    }

    private void privateMethod(String name) {
        System.out.println("private method ...." + name);
    }

    @Override
    public void myInterface() {
        System.out.println("interfaceMethod......");
    }

    @Override
    public void interface2Demo() {
        System.out.println("interfaceMethod2......");
    }
}
