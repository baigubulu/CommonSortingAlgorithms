import java.util.LinkedHashMap;

/**
 * 使用linkedHashMap实现有循序的key值打印输出
 * 按照第一次出现的顺序进行打印
 */

public class CountCharByLinkedHashMap {

    public static LinkedHashMap getCharCount(String inputString){
        char[] charArray = inputString.toCharArray();
        //likedhashMap的key值存在顺序
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap();

        for (char ch : charArray) {
            hashMap.put(ch, hashMap.get(ch) == null ? 1 : hashMap.get(ch) + 1);
        }

        return hashMap;
    }

    public static void main(String[] args){
        LinkedHashMap resulyMap = CountCharByLinkedHashMap.getCharCount("aababccddee");
        resulyMap.forEach((key, value)->{
            System.out.println(key + ":" + value);
        });
    }
}
