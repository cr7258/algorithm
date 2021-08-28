package leetcode.linkedlist;

/**
 * @author chengzw
 * @description
 * @since 2021/8/28
 */
public class Test {
    public static void main(String[] args) {
        int[] num1 = new int[]{9,9,9,9,9,9,9,9,1};
        int val1 = 0;
        for(int i=0;i<num1.length;i++){
            val1 = val1 * 10 + num1[i];
        }
        System.out.println(val1);

        int[] num2 = new int[]{1,9,9,9,9,9,9,9,9,1};
        int val2 = 0;
        for(int i=0;i<num2.length;i++){
            val2 = val2 * 10 + num2[i];
        }
        System.out.println(val2);
    }
}
