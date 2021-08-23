package learning.class01_01;

import java.util.Arrays;

public class Code03_InsertionSort {


    // #########################  实现方法a  #########################
    public static void insertionSort(int[] arr){

        //在0~1之间做到有序
        //在0~2之间做到有序
        //...
        //在0~N-1之间做到有序
        for (int i = 1; i < arr.length; i++) { // 0 ~ i 做到有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {  //只要j的左边比自己小,就不用比了
                swap(arr, j, j + 1);
            }
        }
    }

    //交换元素
    // i和j是一个位置的话，会出错 ，自己^自己就是0了
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // #########################  测试方法b  #########################

    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }


    //   ######################### 对数器 ###################################

    //随机生成数组
    public static int[] generateRandomArray(int maxSize,int maxValue){

        int[] arr = new int[(int) ((maxSize+1) * Math.random())];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }


    //拷贝数组
    public static int[] copyArray(int[] arr){
        if (arr == null) {
            return null;
        }
        int[] arr2 = new int[arr.length];
        for( int i = 0; i < arr2.length; i++){
            arr2[i] = arr[i];
        }
        return arr2;
    }


    //判断方法a和方法b的结果是否相同
    public static boolean isEqual(int[] arr1, int[] arr2){
        if ((arr1 != null && arr2 == null) || (arr1 == null && arr2 !=null)){
            return false;
        }
        if (arr1 == null && arr2 == null){
            return true;
        }
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++ ){
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    //打印数组
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int testTime = 1;  //测试次数
        int maxSize = 100;   //数组最大长度
        int maxValue = 100;    //数组元素最大值
        boolean succeed = true;

        for (int i = 0; i < testTime; i++){
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);
            insertionSort(arr1);
            comparator(arr2);
            if(!isEqual(arr1,arr2)){
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
