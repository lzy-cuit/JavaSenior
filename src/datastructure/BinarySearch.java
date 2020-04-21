package datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linzhiyu
 * @date 2020/4/2 10:15 上午
 * @Email:1360482168@qq.com
 * @Describe
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,9,9,9,9,9,9,10,12,13};
//        int a = binarySearch(array,0,array.length-1,3);
//        System.out.println(a);
        List<Integer> list = binarySearch2(array,0,array.length-1,9);
        System.out.println(list);

    }
    public static int binarySearch(int[] arr,int left,int right,int findVal){
        if (left >= right){
            return -1;
        }
        int p = (left + right) / 2;

        if (findVal > arr[p]){
            return binarySearch(arr,p+1,right,findVal);
        }else if (findVal < arr[p]){
            return binarySearch(arr,left,p,findVal);
        }else {
            return p;
        }

    }

    /** 
    * @Description: 使用二分查找出排序数组里面的指定的元素，重复的也可以查找出来 
    * @Param: [arr, left, right, findVal] 
    * @return: java.util.ArrayList<java.lang.Integer> 
    * @Author: linzhiyu
    * @Date: 2020/4/12 
    */ 
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        if (left > right){
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal){
            return binarySearch2(arr,mid+1,right,findVal);
        }else if (findVal < midVal){
            return binarySearch2(arr,left,mid-1,findVal);
        }else {
            ArrayList<Integer> integers = new ArrayList<Integer>();
            int temp = mid - 1;
            while (true){
                if (temp < 0 || arr[temp] != findVal){
                    break;
                }
                integers.add(temp);
                temp -= 1;
            }
            integers.add(mid);
            temp = mid + 1;
            while (true){
                if (temp > arr.length-1 || arr[temp] != findVal){
                    break;
                }
                integers.add(temp);
                temp += 1;
            }
            return integers;
        }

    }

}
