package datastructure; /*
 * @author  linzhiyu
 * @date  2020/2/19 15:52
 * @Email:1360482168@qq.com
 */

import java.util.Scanner;

public class QueueTest {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';//接收用户输入。
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show):显示数据");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到对列");
            System.out.println("g(get):从队列获取数据");
            System.out.println("h(head):显示队列头部数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.printf("请输入要添加的数据");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int data = queue.getQueue();
                        System.out.printf("取出的数据是：%d\n",data );
                    }catch (Exception e){
                        System.out.printf(e.getMessage());
                    }
                    break;
                case 'h'://查看队列头的数据
                    try{
                        int headdata = queue.headQueue();
                        System.out.println("队列头部数据为" + headdata);
                    } catch (Exception e){
                        System.out.printf(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
        System.out.printf("程序退出");
    }
}

class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，front指向队列的前一个位置。
        rear = -1;//指向队列尾部，指向队列的队尾的数据。
    }
    //判断队列是否为满
    public boolean isFull(){
        return rear == maxSize - 1;
    }
    //判断队列是否为空
    private boolean isEmpty(){
        return rear == front;
    }
    //把数据加入到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        arr[++rear] = n;
    }
    //数据出队列
    public int getQueue(){
        if (isEmpty()){
            //通过抛出异常处理。
            throw new RuntimeException("队列为空，不能获取数据\n");
        }
        return arr[++front];
    }
    //显示数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列空，没有数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示队列的头部数据，注意不是取出数据。
    public int headQueue(){
        //判断
        if (isEmpty()){
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front + 1];
    }



}