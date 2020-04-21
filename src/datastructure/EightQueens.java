package datastructure;

/**
 * @author linzhiyu
 * @date 2020/3/31 5:54 下午
 * @Email:1360482168@qq.com
 * @Describe
 *
     * 在8*8的国际象棋摆放八个皇后，使其不能互相攻击，
     * 即：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆发（92）
 *
 * 算法：1、先用一个一维数组来存储八个皇后和其位置
 *      2、判断皇后之间相互攻击的情况
 *      3、开始进行皇后的摆放
 *      4、输出数组
 *
 *
 */
public class EightQueens {
    int MAX = 8;//表示有几个皇后
    //数组array用来存储每一个皇后存储的位置，array的下标表示第几个皇后，值表示在第几列。
    int[] array = new int[MAX];
    static int count = 0;
    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.check(0);
        System.out.println(count);
    }

    /**
    * @Description:  用来进行皇后的递归和回溯
    * @Param: []
    * @return: void
    * @Author: linzhiyu
    * @Date: 2020/3/31
    */
    public void check(int n){
        //先判断递归结束条件
        if (n == MAX){//表示已经到了第9个皇后了，表示递归已经完成来
            print();
            return;
        }
        //依次放入皇后判断是否冲突
        for (int i = 0; i < MAX; i++) {
            array[n] = i;
            if (judge(n)){//不冲突
                //开始放第n+1个皇后
                check(n+1);
            }
        }
    }
    /**
    * @Description:  判断皇后之间相互攻击的情况
    * @Param: [n]
    * @return: boolean
    * @Author: linzhiyu
    * @Date: 2020/3/31
    */
    public boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[i] - array[n])){
                return false;
            }
        }
        return true;
    }
    public void print(){
        count++;
        for (int i = 0; i < MAX; i++) {
            System.out.print(array[i] + "->");
        }
        System.out.println();
    }

}
