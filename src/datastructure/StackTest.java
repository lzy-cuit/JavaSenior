package datastructure;

/**
 * @author linzhiyu
 * @date 2020/3/30 8:36 下午
 * @Email:1360482168@qq.com
 * @Describe
 */
public class StackTest {
    public static void main(String[] args) {
        StackArray array = new StackArray(10);
        array.push(10);
        array.push(11);
        array.push(12);
        array.push(13);
        array.push(14);
        array.showStack();
    }
}

class StackArray{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public StackArray(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    //判断栈空的函数
    public boolean isEmpty(){
        return top == -1;
    }
    //判断栈是否为满
    public boolean isFull(){
        return top == maxSize -1;
    }
    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        stack[++top] = value;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top--] ;
        return value;
    }
    //遍历栈
    public void showStack(){
        if (isEmpty()){
            System.out.println("栈为空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("第%d个元素是%d\n",i,stack[i]);
        }
    }

}
