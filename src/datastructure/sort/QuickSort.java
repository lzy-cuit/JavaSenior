package datastructure.sort;

import java.util.Arrays;

/**
 * @author linzhiyu
 * @date 2020/4/1 5:41 下午
 * @Email:1360482168@qq.com
 * @Describe
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{6,9,5,7,8};
        System.out.println(Arrays.toString(array));
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
    public static void quickSort(int[] arr,int low,int high){
        int p,i,j,temp;
        if (low >= high){
            return;
        }
        i = low;
        j = high;
        p = arr[low];
        while (i < j){
            while (arr[j] >= p && i < j){
                j--;
            }
            while (arr[i] <= p && i < j ){
                i++;
            }
            if (i < j ){
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        arr[low] = arr[i];
        arr[i] = p;
        quickSort(arr,low,j-1);
        quickSort(arr,j+1,high);


    }

}
