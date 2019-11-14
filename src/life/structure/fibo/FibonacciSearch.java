package life.structure.fibo;

import java.util.Arrays;

/**
 * 斐波那契数组
 *
 */
public class FibonacciSearch {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(initFinonacci(10)));
        int[] arr = initFinonacci(10);
        // 使用插入查找法，找到55的索引
//        System.out.println(insertSearch(arr,0,arr.length-1,55));
        System.out.println(whileInsertSearch(arr,0,arr.length-1,70));

    }

    /**
     * 递归的方式获取值
     *
     * 因为插入查找算法，是将目标值带入了计算当中，所以我们是需要计算出和目标值大小相近的位置，
     *
     * 如果目标值大于数组中的最大值，就有可能会数组越界
     *
     * @param arr
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int insertSearch(int[] arr,int low,int high,int target){
        // 递归退出，一定要在所有代码之前判断
        if(low > high){
            return -1;
        }
        // 插入查询的方式获取中间值，将目标值带入了计算
        int mid = low + (high-low) * (target -arr[low]) / (arr[high] - arr[low]);

        if(arr[mid] < target){
            return insertSearch(arr,mid+1,high,target);
        }else if(arr[mid] > target){
            return insertSearch(arr,low,mid-1,target);
        }else{
            return mid;
        }



    }

    /**
     * 使用while循环的方式
     * @param arr
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int whileInsertSearch(int[] arr,int low,int high,int target){

        while(low < high){
            int mid = low + (high-low) * (target-arr[low]) / (arr[high] - arr[low]);
            if(arr[mid] > target){
                high = mid -1;
            }else if(arr[mid] < target){
                low = mid +1;
            }else{
                return mid;
            }
        }
        return -1;

    }



    /**
     * 生产多少个斐波那契数
     * @param num
     * @return
     */
    public static int[] initFinonacci(int num){

        // 需要验证num

        int[] fibo = new int[num];
        fibo[0] = 1;
        fibo[1] = 1;
        for(int i=2;i<num;i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        return fibo;
    }

}
