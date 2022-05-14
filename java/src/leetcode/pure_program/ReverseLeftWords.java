package leetcode.pure_program;

/**
 * @author chengzw
 * @description 左旋字符串，https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * @since 2021/8/18
 */
public class ReverseLeftWords {
    public static String solution1(String s, int n) {
        int length = s.length();
        char[] newChar = new char[length];
        char[] oldChar = s.toCharArray();
        int k = 0;
        //先放n后面的字符串
        for (int i = n; i < length; i++) {
            newChar[i - n] = oldChar[i];
            k++;
        }
        //再放n前面的字符串
        for (int j = 0; j < n; j++) {
            newChar[k] = oldChar[j];
            k ++;
        }
        System.out.println(newChar);
        return new String(newChar);
    }

    public static void main(String[] args) {
        System.out.println(solution1("abcdefg",2));
    }
}
