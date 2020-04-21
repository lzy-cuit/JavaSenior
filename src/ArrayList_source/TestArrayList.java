package ArrayList_source;

import org.junit.Test;

import java.util.*;

/**
 * @author linzhiyu
 * @date 2020/3/15 11:44
 * @Email:1360482168@qq.com
 * @Describe
 */
public class TestArrayList {

    @Test
    public void  test1(){}{

        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(10);
        list.add(1);
        list.add(10);
        list.add(1);
        list.add(11110);
        list.add(3,12);
//        int size = list.size();
//        System.out.println(size);
//        Integer set = list.set(1, 1111);
//        list.remove(1);
//        System.out.println("***" + list.indexOf(11110));
        Object[] objects = list.toArray();

        System.out.println("*************************");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }

    @Test

    /** 
    * @Description:
    * @Param: [] 
    * @return: void 
    * @Author: linzhiyu
    * @Date: 2020/3/29 
    */ 
    public void test2(){
        int[] array = new int[]{1,2,3,4,5};
        List list = new ArrayList();
        for(int i : array){
            list.add(i);
        }
        System.out.print(list);
    }
    @Test
    public void test3(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.size());
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
        System.out.println(iterator.next());
        }
    }
    @Test
    public void test4(){
        HashSet<Integer> set = new HashSet<>();
    }
}
//class Solution {
//    public int[] reversePrint(ListNode head) {
//        Stack<Object> stack = new Stack();
//        ListNode temp = head;
//        if (temp != null){
//            stack.push(temp);
//            temp = temp.next;
//        }
//        int size = stack.size();
//        int[] p = new int[size];
//        for (int i = 0;i < size;i++){
//            p[i] = stack.pop().val;
//        }
//        return p;
//    }
//}