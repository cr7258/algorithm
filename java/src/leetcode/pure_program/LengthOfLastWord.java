package leetcode.pure_program;

/**
 * @author chengzw
 * @description 最后一个单词的长度，https://leetcode-cn.com/problems/length-of-last-word/
 * @since 2021/8/18
 */
public class LengthOfLastWord {

    public static int solution1(String s){
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println(solution1("Hello World"));
    }
}
