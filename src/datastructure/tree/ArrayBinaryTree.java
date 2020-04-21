package datastructure.tree;

/**
 * @author linzhiyu
 * @date 2020/4/12 6:24 下午
 * @Email:1360482168@qq.com
 * @Describe 实现顺序存储二叉树的前序遍历
 *          1、顺序存储的二叉树是完全二叉树
 */
public class ArrayBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinary arrayBinary = new ArrayBinary(arr);
        arrayBinary.preOrder();
    }



}
class ArrayBinary{
    private int[] arr;

    public ArrayBinary(int[] arr) {
        this.arr = arr;
    }

    //前序遍历顺序存储的二叉树

    /**
     * 2*i+1表示当前节点的左子节点
     * 2*i+2表示当前节点的右子节点
     * @param i
     */
    public void preOrder(int i){
        int length = arr.length;
        if (arr == null && length == 0){
            System.out.println("二叉树为空");
        }
        System.out.println(arr[i]);
        if (2*i+1 < length){
            preOrder(2*i+1);
        }
        if (2*i+2 < length){
            preOrder(2*i+2);
        }

    }
    public void preOrder(){
        this.preOrder(0);
    }
}

