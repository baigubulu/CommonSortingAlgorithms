package isValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目信息：给定一个字符串所表示的括号序列，包含以下字符： '(', ')', '{', '}','[' and']'，判断是否是有效的括号序列
 * leetcode上面的原题
 */
public class isValidParentheses {

    /**
     * 判断括号是否完整的实现方法
     * @param str
     * @return
     */
    public boolean isValidParentheses(String str) {
        int len = str.length();
        /**
         * 字符串为null
         * 字符串长度为0
         * 字符串长度不是偶数
         * peek: 获取栈顶元素
         * pop：弹出栈顶元素
         */
        if (str == null || len == 0 || len % 2 != 0) {
            return false;
        }

        char start = str.charAt(0);
        char end = str.charAt(len - 1);
        if (start == '}' || end == ')' || end == ']') {
            return false;
        }
        if (start == '{' || start == '(' || start == '[') {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            // 如果是左括号直接添加近堆栈
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == '}' || ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char peek = stack.peek();
                    if (isMatch(peek, ch)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isMatch(char c1, char c2) {
        return (c1 == '{' && c2 == '}' || c1 == '(' && c2 == ')' || c1 == '[' && c2 == ']');
    }

    /**
     * 比较简单的实现方式
     * @param str
     * @return
     */
    public boolean isValidParentheses2(String str) {
        int len = str.length();
        if (str == null || len == 0 || len % 2 != 0) {
            return true;
        }

        char[] chars = str.toCharArray();
        Deque<Character> stack = new ArrayDeque<>(chars.length);
        for (char ch : chars) {
            if (ch == '{') {
                stack.push('}');
            } else if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
                /**
                 * 右面括号执行下面的语句，判断当前的ch和栈里面存储的ch是否相等
                 */
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
