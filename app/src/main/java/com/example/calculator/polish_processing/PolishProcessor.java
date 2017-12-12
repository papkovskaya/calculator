package com.example.calculator.polish_processing;

import java.util.LinkedList;

/**
 * Created by Ольга on 20.10.17.
 */

public class PolishProcessor {
    static boolean isDelim(char c) {
        return c == ' ';
    }
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^';
    }
    static int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    static void processOperator(LinkedList<Double> st, char op) {
        Double r = st.removeLast();
        Double l;
        if (st.size() == 0){
            l = 0.0;
        } else {
            l = st.removeLast();
        }

        switch (op) {
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                st.add(l / r);
                break;
            case '%':
                st.add(l % r);
                break;
            case '^':
                st.add(Math.pow(l,r));
                break;
        }
    }

    public static Double eval(String s) {
        LinkedList<Double> st = new LinkedList<>();
        LinkedList<Character> op = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDelim(c))
                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st,op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperator(st, op.removeLast());
                op.add(c);
            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i)) || i < s.length() && s.charAt(i) == '.' )
                    operand += s.charAt(i++);
                --i;
                st.add(Double.parseDouble(operand));

            }
        }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0);
    }
}
