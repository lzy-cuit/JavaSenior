package datastructure.sort;

/**
 * @author linzhiyu
 * @date 2020/3/31 7:47 下午
 * @Email:1360482168@qq.com
 * @Describe
 */
public class SortTest {
    public static void main(String[] args) {
//        System.out.println("请输入需要排序的数,以空格隔开：");
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.next().toString();
//        String[] arr = str.split(",");
//        int[] array = new int[arr.length];
//        for (int i = 0; i <array.length ; i++) {
//            array[i] = Integer.parseInt(arr[i]);
//        }
        int[] array = {1,34,54,65,3,78,56,44};
        System.out.println("需要排序的数是：");
        show(array);

        System.out.println("冒泡排序后的数组");

        show(bubbleSort(array));

        System.out.println("插入排序后的数组");
        show(insertSort(array));

        System.out.println("选择排序后的数组");
        show(selectSort(array));



    }


    /**
    * @Description: 冒泡排序的测试
    * @Param: []
    * @return: void
    * @Author: linzhiyu
    * @Date: 2020/3/31
    */
    public static int[] bubbleSort(int[] arr){
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 -i; j++) {
                if (arr[j] >= arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }

        return arr;

    }

    /**
    * @Description: 插入排序
    * @Param: [arr]
    * @return: int[]
    * @Author: linzhiyu
    * @Date: 2020/4/1
    */
    public static int[] insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i-1;
            for (; j>=0 && arr[j] > temp; j--) {
                arr[j+1] = arr[j];
            }
            arr[j + 1] = temp;
         }
        return arr;
    }
    /**
    * @Description: 选择排序
    * @Param: [arr]
    * @return: int[]
    * @Author: linzhiyu
    * @Date: 2020/4/1
    */
    public static int[] selectSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            //是为了找出第一趟里面最小的那个值的索引
            for (int j = i+1; j < arr.length - 1; j++) {
                if (arr[min] > arr[j]){
                   min = j;
                }
            }
            //然后和最小值的索引进行交换
            if (min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }
    public static void show(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }
}
