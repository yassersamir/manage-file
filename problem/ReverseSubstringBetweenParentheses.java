package com.yasser.managefile.problem;

import java.util.Stack;

public class ReverseSubstringBetweenParentheses {

    private final static String OPEN_PARENTHESES = "(";
    private final static String CLOSE_PARENTHESES = ")";

    public static void main(String[] args) {

        System.out.println(reverseSubstring("abd(jnb)asdf").equals("abd(bnj)asdf"));
        System.out.println(reverseSubstring("abdjnbasdf").equals("abdjnbasdf"));
        System.out.println(reverseSubstring("dd(df)a(ghhh)").equals("dd(fd)a(hhhg)"));
        System.out.println(reverseSubstring("dd(df)a()").equals("dd(fd)a()"));

    }

    private static String reverseSubstring(String s) {
        if (!s.contains(OPEN_PARENTHESES))
            return s;

        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> charsStack = new Stack<>();
        boolean betweenParentheses = false;

        for (Character c : s.toCharArray()) {
            if (CLOSE_PARENTHESES.equals(c.toString())) {
                stringBuilder.append(getStackElements(charsStack))
                        .append(c);//close parentheses
                betweenParentheses = false;
            } else if (betweenParentheses) {
                charsStack.push(c);
            } else if (OPEN_PARENTHESES.equals(c.toString())) {
                stringBuilder.append(c);//open parentheses
                betweenParentheses = true;
            } else
                stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static String getStackElements(Stack<Character> charStack) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!charStack.isEmpty()) {
            stringBuilder.append(charStack.pop());
        }
        return stringBuilder.toString();
    }

}
