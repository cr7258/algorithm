package leetcode.pure_program;

/**
 * @author chengzw
 * @description 替换空格，https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * @since 2021/8/18
 */
public class ReplaceSpace {
    public static String solution1(String s) {
        StringBuilder sb = new StringBuilder();
        char[] newChar = s.toCharArray();
        for (int i = 0; i < newChar.length; i++) {
            if (newChar[i] != ' ') {
                sb.append(newChar[i]);
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution1("We are happy."));
    }
}
