package datastructure.sort;

import java.util.Arrays;

/**
 * @author linzhiyu
 * @date 2020/4/13 18:18
 * @Email:1360482168@qq.com
 * @Describe
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {2,4,1,67,34,23,98,67,5,644,55,23,11,31,76,12};
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void HeapSort(int[] arr){
        //构建大顶堆
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        //调整堆结构+交换堆顶元素与堆末元素
        for (int i = arr.length-1; i > 0 ; i--) {
            swap(arr,0,i);
            adjustHeap(arr,0,i);
        }

    }
    /**
     * 交换一次数据过程
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        for (int j = 2*i+1; j < length ; j=j*2+1) {
            if (j+1<length && arr[j] < arr[j+1] ){
                j++;
            }
            if (arr[j]>temp){
                arr[i]=arr[j];
                i=j;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
