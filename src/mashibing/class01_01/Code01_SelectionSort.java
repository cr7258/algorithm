package mashibing.class01_01;

import java.util.Arrays;

public class Code01_SelectionSort {


    // #########################  实现方法a  #########################
    public static void selectionSort(int[] arr){
        if (arr.length <2 || arr == null){
            return;
        }
        //遍历下标0~N-1，找到最小值放在0位置
        //遍历下标1~N-1，找到最小值放在1位置
        //遍历下标2~N-1，找到最小值放在2位置
        //...
        //遍历下标N~N-1，找到最小值放在N位置在
        for(int i = 0; i<arr.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){ // i ~ N-1 上找最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);  //将最小值放到指定位置
        }
    }
    
    
    //交换元素
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    //#########################  测试方法b #########################
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }



//   ######################### 对数器 ###################################
    //随机生成数组
    public static int[] generateRandomArray(int maxSize,int maxValue){
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * N)  [0, N-1]
        int[] arr = new int[(int)((maxSize+1) * Math.random())];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
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
            selectionSort(arr1);
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
