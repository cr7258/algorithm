package leetcode.regular_program;

/**
 * @author chengzw
 * @description 一次编辑，https://leetcode-cn.com/problems/one-away-lcci/
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * <p>
 * 思路：1.两个字符串的长度不能超过1。
 * 2.按照字符依次往后比较，允许有1次不同（插入或者删除）。
 * 3.当发现不同的字符以后，后面的都必须相同。
 * @since 2021/8/20
 */
public class OneEditAway {

    public static boolean solution1(String first, String second) {
        int n = first.length();
        int m = second.length();

        //两个字符串的长度不能超过1
        if (Math.abs(n - m) > 1) return false;


        //两个字符串的指针
        int i = 0;
        int j = 0;

        //当第一次遇到字符不相同时
        while (i < n && j < m && first.charAt(i) == second.charAt(j)) {
            i++;
            j++;
        }
        //如果两个字符串长度相等，替换字符
        if (n == m) {
            i++;
            j++;
        }
        //如果两个字符串长度不同，插入或者删除字符
        else if (n > m) {
            i++;
        } else {
            j++;
        }

        //之后每个字符都必须相同
        while (i < n && j < m) {
            if (first.charAt(i) != second.charAt(j)) return false;
            i++;
            j++;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(solution1("ab","bc"));
    }
}
