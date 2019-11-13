package stack;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */


public class ValidParentheses {

    private static Map<Character, Character> mMap = new HashMap<>();

    public static void main(String[] args) {

        //准备
        mMap.put(')', '(');
        mMap.put('}', '{');
        mMap.put(']', '[');
        //验证
        isValid("{}[]");
        isValid("{{}}[[]]}");
        isValid("{{}}[[]]{");
        isValid("([)]");


    }

    private static boolean isValid(String strs) {
        System.out.println("input:" + strs);
        //双向队列
        LinkedList<Character> mDeque = new LinkedList<>();
        for (Character c : strs.toCharArray()) {
            if (mMap.containsKey(c)) {
                Character popChar;
                popChar = mDeque.pollLast();
                if (valid(c, popChar)) {
                    continue;
                } else {
                    System.out.println("比对失败");
                    return false;
                }
            } else {
                mDeque.add(c);
            }
        }

        if (mDeque.isEmpty()) {
            System.out.println("验证成功");
            return true;
        } else {
            System.out.println("验证失败");
            return false;
        }
    }


    private static boolean valid(Character c, Character popChar) {
        if (popChar == null) {
            return false;
        }
        return mMap.get(c).equals(popChar);
    }


}
