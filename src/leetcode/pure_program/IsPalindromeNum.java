package leetcode.pure_program;

/**
 * @author chengzw
 * @description 回文数，https://leetcode-cn.com/problems/palindrome-number/
 * @since 2021/8/18
 */
public class IsPalindromeNum {

    public static boolean solution1(int x) {
        //-2147483648 ~ 2147483647
        int[] digits = new int[10];
        if (x < 0) return false;
        //将x转化成字符串数组
        int k = 0;
        while (x > 0) {
            digits[k] = x % 10;
            x = x / 10;
            k++;
        }
        //判断回文数
        for (int i = 0; i < k / 2; i++) {
            if (digits[i] != digits[k - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean solution2(int x) {
        if (x < 0) return false;
        int backupX = x;
        //y为x反转后的数，有可能溢出
        int y = 0;
        while (x > 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return backupX == y;
    }

    public static void main(String[] args) {
        System.out.println(solution1(121));
        System.out.println(solution2(121));
    }
}
