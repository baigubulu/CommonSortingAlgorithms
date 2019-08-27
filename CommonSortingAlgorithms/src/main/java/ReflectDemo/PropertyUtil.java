package ReflectDemo;

import java.lang.reflect.Field;

//解决set方法过多的情况
public class PropertyUtil {
    /**
     * 通过反射实现
     * per.setXxx(value)
     * @param object
     * @param PropertyName
     * @param value
     */
    public void setProperty(Object object, String PropertyName, Object value) {
        //获取到反射入口
        Class clazz = object.getClass();
        try {
            Field field = clazz.getDeclaredField(PropertyName);
            //因为该方法是私有的，所有需要把类型换成public
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException il) {
            il.printStackTrace();
        }
    }
}
