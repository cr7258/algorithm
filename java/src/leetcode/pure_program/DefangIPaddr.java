package leetcode.pure_program;

/**
 * @author chengzw
 * @description IP 地址无效化，https://leetcode-cn.com/problems/defanging-an-ip-address/
 * 不能直接使用 replace 方法
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * @since 2021/8/17
 */
public class DefangIPaddr {
    public static String solution1(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (c != '.') { //注意字符用单引号表示
                sb.append(c);
            } else { //如果这个字符是 '.'，则用 '[.]' 拼接。
                sb.append("[.]");
            }
        }
        return sb.toString();
    }

    public static String solution2(String address) {
        char[] oldChar = address.toCharArray();
        int n = address.length();
        char[] newChar = new char[n + 2 * 3];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (oldChar[i] != '.') {
                newChar[k] = oldChar[i];
                k++;
            } else {
                newChar[k++] = '[';
                newChar[k++] = '.';
                newChar[k++] = ']';
            }
        }
        return new String(newChar);
    }

    public static void main(String[] args) {
        System.out.println(solution1("1.1.1.1"));
        System.out.println(solution2("1.1.1.1"));
    }
}
