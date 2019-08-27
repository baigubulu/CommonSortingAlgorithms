package IndexOf;

/**
 * 实现String的indexof函数 -- 该函数主要完成在src字符串中查询target字符串第一次出现的位置
 */
public class IndexOf {

    public static int indexof(String src, String target) {
        //将输入的数据转化成char数组
        char[] charSrc = src.toCharArray();
        char[] charTarget = target.toCharArray();
        //原数组和目标数组的长度
        int srcCount = charSrc.length;
        int targetCount = charTarget.length;

        //校验程序，源串和目标串的校验
        if (charSrc == null || charSrc.length < 1 || charTarget == null || charTarget.length < 1) {
            return -1;
        }
        if (charTarget.length > charSrc.length) {
            return -1;
        }

        /**
         * 核心实现程序
         */
        for (int i = 0; i < srcCount; i++) {
            boolean find = false;
            //源数组第i个数据和目标数组的第一个数据开始比较，并且源数组的长度要大于目标数组的长度
            if (charSrc[i] == charTarget[0] && (srcCount >= targetCount + i)) {
                //记录相等的数量
                int equalCount = 0;
                //当第一个相等之后，开始根据目标数组的长度进行遍历，判断后续的数组长度是否相等
                for (int j = 0; j < targetCount; j++) {
                    if (charSrc[i + j] == charTarget[j]) {
                        //判断相等的位数
                        equalCount++;
                    }
                }
                //当记录的数组长度和目标字符串的长度之后，代表找到了目标数组
                if (equalCount == targetCount) {
                    find = true;
                }
            }
            //当标记位为true的之后，表示找到了字符串
            if (find) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = indexof("aabbcc", "ccb");
        if (i == -1) {
            System.out.println("该字符串不存在");
            return;
        }
        System.out.println(i);
    }
}
