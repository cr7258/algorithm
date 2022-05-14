package leetcode.pure_program;

/**
 * @author chengzw
 * @description 验证回文串，https://leetcode-cn.com/problems/valid-palindrome/
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * @since 2021/8/17
 */
public class IsPalindrome {

    public static boolean solution1(String s) {
        char[] newChar = s.toCharArray();
        System.out.println(newChar);
        //两个指针
        int i = 0;
        int j = s.length() - 1;
        System.out.println(j);

        while (j > i) {
            // 不是数字或字⺟的话，i就⼀直++
            if (!isAlpha(newChar[i])) {
                i++;
                continue;
            }

            // 不是数字或字⺟的话，j就⼀直--
            if (!isAlpha(newChar[j])) {
                j--;
                continue;
            }

            //⾛到这⾥的话，i、j都指向数字或字⺟，看看两个字符是否相同
            if (toLower(newChar[i]) != toLower(newChar[j])) {
                return false;
            } else {
                // i和j往中间挪⼀位
                i++;
                j--;
            }
        }
        return true;
    }

    //判断是否是字母
    public static boolean isAlpha(char c) {
        if (c >= '0' && c <= '9') return true;
        if (c >= 'a' && c <= 'z') return true;
        if (c >= 'A' && c <= 'Z') return true;
        return false;
    }

    //大写转小写
    public static char toLower(char c) {
        if (c >= '0' && c <= '9') return c;
        if (c >= 'a' && c <= 'z') return c;
        //⼤写A~Z 65~90，⼩写a~z 97~122
        return (char) ((int) c + 32);
    }

    public static void main(String[] args) {
        System.out.println(solution1("A man, a plan, a canal: Panama"));
        System.out.println(solution1(".,"));
    }
}


