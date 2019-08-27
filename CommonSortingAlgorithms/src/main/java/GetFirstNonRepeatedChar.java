import java.util.*;

/**
 *  找到第一个不重复的字符
 *  实现该功能存在三种算法
 * @author : wangyu
 */
public class GetFirstNonRepeatedChar {
    /**
     * 算法1：借助于map和set进行实现
     */
    public static char getFirstNonRepeatedChar(String str){
        //LinkedHashMap可以设置数据的长度
        Map<Character, Integer> counts = new LinkedHashMap<>(str.length());

        /**
         * 1. 首先将字符串拆解，存储到map当中
         * 2. 遍历map集合，因为linkedHashMap所存储的key值是存在顺序的，所以遍历key值并比较value是否为1即可得到第一次出现的不重复的字符
         */
        for (char c : str.toCharArray()){
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }

        /**
         * 返回一个set集合，类型为Map.Entry
         * 因为key存在顺序并且不重复，所以使用set来实现
         */
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }


    public static char firstNonRepeatingChar(String word){
        Set<Character> repeating = new HashSet<Character>();
        List<Character> nonRepeating = new ArrayList<Character>();

        /**
         * 创建两个集合，第一个集合存放重复的字符，第二个集合存在不重复的集合，因为不重复的集合是ArrayList，所以还集合是存在顺序的，只需要去处第一个字符即可
         */
        for (int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            if (repeating.contains(letter)){
                continue;
            }
            if (nonRepeating.contains(letter)){
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.get(0);
    }

    /**
     * 首先遍历整个字符，将字符和出现次数存储到Map当中
     * 2. 因为Map的无序性，因此重新对String进行遍历，在Map中取出数值，得到结果
     * @param word
     * @return
     */
    public static char firstNonRepeatedCharachter(String word){
        HashMap<Character, Integer> scoreboard = new HashMap<Character, Integer>();
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (scoreboard.containsKey(c)) {
                scoreboard.put(c, scoreboard.get(c) + 1);
            } else {
                scoreboard.put(c, 1);
            }
            //使用HashMap实现功能
            for (int j = 0; j < word.length(); j++){
                char result = word.charAt(j);
                if (scoreboard.get(result) == 1){
                    return result;
                }
            }
        }
        throw new RuntimeException("Undefined behaviour");
    }

    public static void main(String[] args) {
        String array = "abceaabc";
        char ch = GetFirstNonRepeatedChar.getFirstNonRepeatedChar(array);
        System.out.println(ch);
    }
}
