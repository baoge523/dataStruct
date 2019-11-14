package life.sort;

import java.util.Arrays;

/**
 *  冒泡排序
 *          时间复杂度  O(n^2)  最好是O(n) 最坏是O(n^2)
 *          空间复杂度  O(1)
 *          稳定排序
 *
 *        也可以有优化
 *
 *      每次冒泡都会将最大的值，冒泡到最后面去，因为每次都是相邻值的交换，说明是稳定排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,4,5,3,7,6};
        bubbleSortAdd(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        // 外层循环控制冒泡的次数
        for(int i=0;i<arr.length-1;i++){

            // 内存循环控制比较次数--注意:在比较的时候，我们的交换会使用到j+1，所以我们的值不能取到最后一个数，
            // 如果是最后一个数，当执行 j+1的时候，就会抛出越界异常
            for(int j=0;j<arr.length-1-i;j++){

                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }
    }

    /**
     * 如果是已经有序的了，那么就应该直接退出
     * @param arr
     */
    public static void bubbleSortAdd(int[] arr){
        // 外层需要控制冒充次数
        for(int i=0;i<arr.length-1;i++){

            boolean flag = true;
            // 内存循环控制比较次数，注意：比较的时候的 j+1
            for(int j=0;j<arr.length-1-i;j++){
                // 如果在一次冒泡中，存在比较需要交换位置，那么说明还没有有序
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }

            }
            if(flag){
                break;
            }

        }

    }

}
