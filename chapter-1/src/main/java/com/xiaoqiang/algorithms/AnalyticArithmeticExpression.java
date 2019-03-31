package com.xiaoqiang.algorithms;

public class AnalyticArithmeticExpression {

    private static char LEFT_BRACKET = '(';
    private static char RIGHT_BRACKET = ')';
    private static char BLANK_CHAR = ' ';


    public static int calculation(String expression) {
        Stack<Operator> ops = new Stack<>();
        Stack<Integer> opsNums = new Stack<>();

        for (char c : expression.toCharArray()) {
            //忽略左括号以及空字符
            if (c == BLANK_CHAR || c == LEFT_BRACKET) {
                continue;
            }
            //遇到右括号
            // 1 操作符出栈
            // 2 操作数出栈（出栈操作符所需的个数，演示为四则运算，故每次出栈两个操作数）
            if (c == RIGHT_BRACKET) {
                int num1 = opsNums.pop();
                int num2 = opsNums.pop();
                Operator op = ops.pop();
                int tempResult = op.calc(num2, num1);
                opsNums.push(tempResult);
            } else if (((int) c) >= 48 && ((int) c) <= 57) { //数字直接入栈
                int num = (int) c - 48;
                opsNums.push(num);
            } else if (Operator.valueOfChar(c) != null) {  //操作符直接入栈
                ops.push(Operator.valueOfChar(c));
            } else { //其余字符出现说明表达式非法
                throw new IllegalArgumentException("illegal express!");
            }
        }

        //当操作符栈不为空,且操作数个数大于1时继续处理
        while (!ops.isEmpty() && opsNums.size() > 1) {
            int num1 = opsNums.pop();
            int num2 = opsNums.pop();
            Operator op = ops.pop();
            int tempResult = op.calc(num2, num1);
            opsNums.push(tempResult);
        }
        //最终仍有多余操作符或者超过一个操作数时，表达式非法
        if (ops.size() > 0 || opsNums.size() > 1) {
            throw new IllegalArgumentException("illegal express!");
        }
        return opsNums.pop();
    }

    public static void main(String[] args) {
        String testExpress = "3+4";
        System.out.printf("%s = %s\n", testExpress, calculation(testExpress));
        testExpress = "3-4";
        System.out.printf("%s = %s\n", testExpress, calculation(testExpress));
        testExpress = "3*4";
        System.out.printf("%s = %s\n", testExpress, calculation(testExpress));
        testExpress = "4/2";
        System.out.printf("%s = %s\n", testExpress, calculation(testExpress));
        testExpress = "(2+2)/(1+4)";
        System.out.printf("%s = %s\n", testExpress, calculation(testExpress));
        testExpress = "(5-1)*3+5";
        System.out.printf("%s = %s\n", testExpress, calculation(testExpress));
        testExpress = "5-3*(3+5)";
        System.out.printf("%s = %s\n", testExpress, calculation(testExpress));
        testExpress = "2*3+5*9/3";
        System.out.printf("%s = %s\n", testExpress, calculation(testExpress));
        testExpress = "2*(3+5)*9/3";
        System.out.printf("%s = %s\n", testExpress, calculation(testExpress));
    }
}
