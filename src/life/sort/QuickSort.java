package life.sort;

import java.util.Arrays;

/**
 * 普通的快速排序
 *          时间复杂度为 O(nlogn)
 *          空间复杂度  O(logn)
 *          不稳定
 */
public class QuickSort {
    public static void main(String[] args) {
        // 数据初始化，不记录算法时间
        int[] arr = new int[]{2,1,4,5,3,7,6,1,2,3,1,2,3};
        quickSort3(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *    思路:
     *       从右开始，如果小了，和左边交换，然后又从左开始，知道两个指针相等
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr,int start,int end){
        // 不破坏原来的数据
        int s = start; // 开始位置
        int e = end;   // 结束位置
        /**
         * 标准值，可以三点取中，或者多点取中，避免快排退化
         */
        int standard = arr[s]; // 标准值 --单轴快排

        // 如果前指针小于后指针，那么就一直执行，等于时退出
        while(s < e){
            // 每次都需要判断 s < e,因为每次都更改了s或者e

            // 比轴值大，直接--
            while(s < e && arr[e] >= standard){
                e--;
            }
            // 反之，将值覆盖给前面的值，因为第一个值，已经拿来当标准值了，所以位置也就空出来了
            // 后面的，都是基于这样的原理
            if(s < e){
                arr[s] = arr[e];
                s++;
            }
            // 比轴值小的，都直接++
            while(s < e && arr[s] < standard){
                s++;
            }
            // 反之，将大于标准值的放到后面去
            if(s < e){
                arr[e] = arr[s];
                e--;
            }

        }

        // 将拿出来的这个值，让到分界线出
        arr[s] = standard;

        // 执行完了，所有已将数组裁分成三段了

        if(start < s-1){
            quickSort(arr,start,s-1);
        }
        if(s+1 < end){
            quickSort(arr,s+1,end);
        }

    }

    /**
     *  思路:
     *   取最后一个值为标准值，然后从前到后开始遍历，如果有大的值，就和后面的值交换位置
     *   直到两个指针相同为止
     *
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort2(int[] arr,int start,int end){

        int s = start;
        int e = end;

        int standard = arr[end];
        e--;

        while(s < e) {
            if (arr[s] < standard) {
                s++;
            } else {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                e--;
            }
        }
        // 这里需要排除 当s == e 时，是通过 e--交换过来的，
        // 如果是这样的话，那么就不能判断当前交换的值了
        if(arr[s] > standard){
            arr[end] = arr[s];
            arr[s] = standard;
        }else{
            s++;
            arr[end] = arr[s];
            arr[s] = standard;
        }



        if(start < s-1){
            quickSort2(arr,start,s-1);
        }

        if(s+1 < end){
            quickSort2(arr,s+1,end);
        }





    }

    /**
     *  思路:
     *    从前向后遍历，如果遇到大值就交换的同时，从后向前遍历，如果遇到小的就交换。
     *
     *    也是说，当 → 遇到第一个大于的值时，
     *    当 ← 遇到第一个小于的值时，就交换
     *
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort3(int[] arr,int start,int end){

        int s = start;
        int e = end;

        int standard = arr[e];
        e--;

        while( s < e){

            while(s < e && arr[s] < standard){
                s++;
            }
            while(s < e && arr[e] >= standard){
                e--;
            }
            // 交换
            if(s < e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }

        }

        // 当 s == e 时，当arr[s]不会进行判断
        // 所以需要我们自己判断

        /**
         * 如果是大的，那么直接交换
         * 如果是小的，那么向后移一位，再交换
         */
        if(arr[s] < standard){
            s++;
       }
        arr[end] = arr[s];
        arr[s] = standard;

        if(start < s-1){
            quickSort3(arr,start,s-1);
        }
        if(s+1 < end){
            quickSort3(arr,s+1,end);
        }
    }


}
