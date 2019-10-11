package HuiWenNum;

public class HunWenNum {
    /**
     * 判断是否为回文序列
     * @param string
     * @return
     */
    public static boolean isHunWen(String string) {
        char[] temp = string.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            //实现的核心
            if (temp[i] != temp[temp.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取最大回文序列的长度
     * @param string
     * @return
     */
    public static String longestPalindromeSubSequence2(String string) {
        //回文序列的最大长度
        int maxPalinLength = 0;
        //回文序列
        String longestPalindrome = null;
        int length = string.length();

        // check all possible sub strings
        for (int i = 0; i < length; i++) {
            //至少i和j要相差一个数值
            for (int j = i + 1; j < length; j++) {
                //回文串的长度
                int len = j - i;
                //获取回文子串
                String curr = string.substring(i, j + 1);
                if (isHunWen(curr)) {
                    //如果当前字符串的长度大于最长的字符串的长度
                    if (len > maxPalinLength) {
                        longestPalindrome = curr;
                        maxPalinLength = len;
                    }
                }
            }
        }
        System.out.println(maxPalinLength + 1);
        return longestPalindrome;
    }

    /**
     * 判断是否是回文字符串
     * 题目链接：https://leetcode-cn.com/problems/valid-palindrome/
     * 该题目中的回文串可能是带有标点符号的
     * 解题的方式：使用双指针完成整个过程
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        int cnt = 0, j= 0;
        // 去除标点符号以及将字符从大写变成小写的过程
        for (int i = 0; i < cs.length; i++) {
            if (('0' <= cs[i] && cs[i] <= '9') || ('a' <= cs[i] && cs[i] <= 'z')){
                cs[cnt++] = cs[i];
            } else if ('A' <= cs[i] && cs[i] <='Z') {
                cs[cnt++] = (char) (cs[i] - 'A' + 'a');
            }
        }
        cnt--;
        // 从头到尾对整个数组进行遍历
        while (j < cnt) {
            if (cs[j++] != cs[cnt--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String string = "qqqqabc22cba";
        Boolean flag = isHunWen(string);
        System.out.println(flag);
        String subString = longestPalindromeSubSequence2(string);
        System.out.println(subString);
    }
}
