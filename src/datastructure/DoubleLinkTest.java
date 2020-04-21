package datastructure;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author linzhiyu
 * @date 2020/2/24 11:42
 * @Email:1360482168@qq.com
 * @Describe 主要是实现对双向链表的增删改插
 */
public class DoubleLinkTest {
    public static void main(String[] args) {
        int[] array = { 3, 2, 1, 4, 5 };
        int[] array1 = {1,2,4,5,6,7};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int a = Arrays.binarySearch(array,1);
        System.out.println(a);

        boolean f = Arrays.equals(array,array1);
        System.out.println(f);


        //数组转list
        List list = new ArrayList(Arrays.asList(array));

        System.out.println(list);

        String[] array2 = { "a", "b", "c", "d", "e" };
        List<String> list1 = new ArrayList<String>(Arrays.asList(array2));



       for (String i :array2){
           System.out.print(i);

       }
    }



}













