package leetcode.stack;

import java.util.Stack;

/**
 * @author chengzw
 * @description 基本计算器 III，带括号，https://leetcode-cn.com/problems/basic-calculator-iii/
 * <p>
 * 输入：s = "2*(5+5*2)/3+(6/2+8)"
 * 输出：21
 * @since 2021/9/6
 */
public class CalculateBrackets {
    /**
     * 思路：遇到 ( 直接入栈，遇到 ) 弹出计算到 ( 为止
     *
     * @param s
     * @return
     */
    public static int solution1(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            //如果是空格，跳过
            if (c == ' ') {
                i++;
                //如果是数字直接入栈
            } else if (isDigit(c)) {
                int num = 0;
                while (i < n && isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                numStack.push(num);
                //如果左括号，直接入栈
            } else if (c == '(') {
                opStack.push(c);
                i ++;
                //如果是右括号，开始计算，直到遇到左括号
            } else if (c == ')') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    fetchAndCal(numStack, opStack);
                }
                //弹出左括号
                opStack.pop();
                i++;
            }
            //如果是运算符
            else {
                //如果符号栈顶为空，直接入栈
                //如果运算符优先级高于栈顶元素，直接入栈
                if (opStack.isEmpty() || prior(c, opStack.peek())) {
                    opStack.push(c);
                    //如果运算符优先级低于或等于栈顶元素，计算
                } else {
                    while (!opStack.isEmpty() && !prior(c, opStack.peek())) {
                        fetchAndCal(numStack, opStack);
                    }
                    opStack.push(c);
                }
                i++;
            }
        }

        while (!opStack.isEmpty()) {
            fetchAndCal(numStack, opStack);
        }
        return numStack.pop();
    }

    //判断是否是数字
    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    //比较运算符优先级
    public static boolean prior(char opA, char opB) {
        if ((opA == '*' || opA == '/') && (opB == '+' || opB == '-')) return true;
        if (opB == '(') return  true;
        return false;
    }

    //计算
    public static int cal(char op, int numA, int numB) {
        switch (op) {
            case '+':
                return numA + numB;
            case '-':
                return numA - numB;
            case '*':
                return numA * numB;
            case '/':
                return numA / numB;
        }
        return -1;
    }

    //从栈中获取元素，计算，将结果压入数字栈
    public static void fetchAndCal(Stack<Integer> numStack, Stack<Character> opStack) {
        int numB = numStack.pop();
        int numA = numStack.pop();
        char op = opStack.pop();
        int result = cal(op, numA, numB);
        numStack.push(result);
    }

    public static void main(String[] args) {
        System.out.println(solution1("2*(5+5*2)+3"));
    }
}
