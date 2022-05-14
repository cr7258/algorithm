package learning.class01_02;

public class Code01_swap {
    //不用额外变量交换两个数
    //0^N == N      N^N == 0
    //异或运算满足交换律和结合率
    //异或运算就记成无进位相加
    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5};
        swap(arr,0,2);
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
