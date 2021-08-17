package leetcode.pure_program;

/**
 * @author chengzw
 * @description 反转字符串，https://leetcode-cn.com/problems/reverse-string/
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * @since 2021/8/17
 */
public class ReverseString {
    public static void solution1(char[] s) {
        int n = s.length;
        char temp;
        //这⾥下标到底是n/2还是n/2+1可以举⼏个例⼦（奇偶）验证⼀下即可
        for (int i = 0; i < n / 2; i++) {
            //交换数组中两个元素的标准写法
            temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        }
    }

    public static void solution2(char[] s) {
        int n = s.length;
        int i = 0;
        int j = n - 1;
        while (j > i) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] char1 =  new char[]{'h','e','l','l','o'};
        solution1(char1);
        System.out.println(char1);

        char[] char2 =  new char[]{'h','e','l','l','o'};
        solution2(char2);
        System.out.println(char2);
    }
}
