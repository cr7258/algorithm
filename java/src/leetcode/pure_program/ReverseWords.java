package leetcode.pure_program;

/**
 * @author chengzw
 * @description 翻转单词顺序，https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * 输入: "  hello world! "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 输入: "a good  example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * @since 2021/8/17
 */
public class ReverseWords {
    public static String solution1(String s) {
        String[] newString = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = newString.length - 1; i >= 0; i--) {
            if(!newString[i].equals("")){
                sb.append(newString[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(solution1("example   good a"));
    }
}
