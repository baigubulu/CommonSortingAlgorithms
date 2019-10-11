package java.IndexOf;

import java.util.ArrayList;
import java.util.List;

/**
 * splite 函数的实现方式
 */
public class splite {
    public static String[] spliteString(String str, String flag) {
        List<String> list = new ArrayList<>();
        while(str.contains(flag)) {
            int index = str.indexOf(flag);
            String tmp = str.substring(0, index);
            list.add(tmp);
            str = str.substring(index + flag.length());
        }
        list.add(str);
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        System.out.println("拆分的个数为" + list.size());
        return arr;
    }
}
