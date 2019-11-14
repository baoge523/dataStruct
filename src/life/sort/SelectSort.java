package life.sort;

import java.util.Arrays;

/**
 * 选择排序
 *      时间复杂度: O(n^2)  最好，最坏都是
 *      空间复杂度: O(1)
 *      不稳定
 *
 *
 *      可以优化
 *
 *
 *      思路:
 *        每次循环就将比较找到当前的最小的值，然后在这个循环的最后面，将这个值赋值到相对最前的位置。
 *
 *
 */
public class SelectSort {

    public static void main(String[] args) {
        // 数据初始化，不记录算法时间
        int[] arr = new int[]{2,1,4,5,3,7,6};
        selectSortPlusAdd(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 缺点，交换的次数太多了
     * @param arr
     */
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min = arr[i]; // 最小值
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < min){
                    int temp = min;
                    min = arr[j];
                    arr[j] = temp;
                }
            }
            // 最后将当前的最小值，放到对应的位置中去
            arr[i] = min;

        }


    }



    /**
     * 一次循环中，只是保存最小值的索引，最后再来交换值
     * @param arr
     */
    public static void selectSortAdd(int[] arr){

        // 最后一次默认有序
        for(int i=0;i<arr.length-1;i++){
            int minIndex = i;  // 保存最小索引
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            // 如果不是索引改变了，那么就交换位置
            if(minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }


    }

    /**
     * 在一次外部循环中，同时找到最大值和最小值
     * @param arr
     */
    public static void selectSortPlusAdd(int[] arr){

        // 取右中数 min + ((max-min+1)>>1)
        int mid = arr.length >> 1;

        for(int i=0;i<mid;i++){
            int min = i;
            int max = arr.length-1-i;

            // max 是变量不能作为循环判断的条件
            // 查找需要包含自己，如果不包含，可能最小的是最大值，最大的是最小值
            // 多画图分析，然后在debug
            for(int j = i; j<=arr.length-1-i;j++){
                min = arr[j] < arr[min] ? j : min;
                max = arr[j] > arr[max] ? j : max;
            }

            if(min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
            if(max != (arr.length-1-i)){
                int temp = arr[arr.length-1-i];
                arr[arr.length-1-i] = arr[max];
                arr[max] = temp;
            }

        }


    }

    /**
     * 检查一个排序是否是稳定排序
     */
    public static void check(){


    }

}
