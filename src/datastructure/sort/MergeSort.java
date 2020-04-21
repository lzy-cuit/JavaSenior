package datastructure.sort;

import java.util.Arrays;

/**
 * @author linzhiyu
 * @date 2020/4/1 7:10 下午
 * @Email:1360482168@qq.com
 * @Describe
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{34,12,45,98,67,55,44,33,22,78,99,67,41};
        System.out.println(Arrays.toString(array));
        sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] arr,int low,int high){
        if (low <= high){
            int q = (low + high)/2;
            sort(arr,low,q);
            sort(arr,q+1,high);
            merge(arr,low,q,high);
        }

    }
    public static void merge(int[] arr,int low,int mid,int high){

        final int n1 = mid-low+1;
        final int n2 = high-mid;

        final int[] left = new int[n1+1];
        final int[] right = new int[n2+1];

        for (int i = 0; i < n1 ; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < n2 ; i++) {
            right[i] = arr[mid+1+i];
        }
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int n = 0;
        int m = 0;
        for (int k = low; k <= high; k++) {
            if (left[m] > right[n]){
                arr[k] = right[n];
                n++;
            }else {
                arr[k] = left[m];
                m++;
            }
        }

    }
}
