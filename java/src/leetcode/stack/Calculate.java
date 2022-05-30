package leetcode.stack;

import java.util.Stack;

/**
 * @author chengzw
 * @description 计算器，https://leetcode-cn.com/problems/calculator-lcci/
 * <p>
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果
 * 输入: "3+2*2"
 * 输出: 7
 * @since 2021/9/5
 */
public class Calculate {

    /**
     * 思路1：
     * 2个栈，1个栈存数字，1个栈存运算符号
     * 数字直接入栈，
     * 运算符如果优先级高于栈顶符号，直接入栈；如果优先级等于或低于栈顶元素，计算
     *
     * @param s
     * @return
     */
    public static int solution1(String s) {
        //数字
        Stack<Integer> numStack = new Stack<>();
        //运算符号
        Stack<Character> opStack = new Stack<>();
        int n = s.length();
        int i = 0;
        //按字符遍历
        while (i < n) {
            char c = s.charAt(i);
            //特殊情况，空格，直接跳过
            if (c == ' ') {
                i++;
            }
            //如果是数字，直接入栈
            else if (isNum(c)) {
                //如果数字是多位
                int num = 0;
                while (i < n && isNum(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                numStack.push(num);
            }
            //如果是运算符，和栈顶的符号进行比较：
            else {
                //1.如果符号栈中没有符号了
                //2.如果该运算符优先级比栈顶符号高
                //运算符直接入栈
                if (opStack.isEmpty() || prior(c, opStack.peek())) {
                    opStack.push(c);
                    //如果运算符没有栈顶元素高，进行计算
                } else {
                    while (!opStack.isEmpty() && !prior(c,opStack.peek())){
                        fetchAndCal(numStack, opStack);
                    }
                    opStack.push(c);
                }
                i++;
            }
        }

        //剩下的运算符优先级相等
        while (!opStack.isEmpty()){
            fetchAndCal(numStack,opStack);
        }
        return numStack.pop();
    }


    //判断字符是否是数字
    public static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    //获取数字栈顶两个元素，计算，然后将结果压入数字栈
    public static void fetchAndCal(Stack<Integer> numStack, Stack<Character> opStack) {
        // 注意顺序，numB 是先弹出来的，/ 符号计算顺序会有影响
        int numB = numStack.pop();
        int numA = numStack.pop();
        char ops = opStack.pop();
        numStack.push(cal(ops, numA, numB));
    }

    //比较运算符优先级，运算A优先级是否比运算符B高
    private static boolean prior(char opA, char opB) {
        if ((opA == '*' || opA == '/') && (opB == '+' || opB == '-')) return true;
        return false;
    }

    //计算
    private static int cal(char op, int numA, int numB) {
        if (op == '+') return numA + numB;
        if (op == '-') return numA - numB;
        if (op == '*') return numA * numB;
        return numA / numB;
    }

    public static void main(String[] args) {
        System.out.println(solution1("3+2*2"));
        System.out.println(solution1("3/2"));
        System.out.println(solution1(" 99 "));
        System.out.println(solution1("1+1+1"));
    }
}
