package datastructure;
/*
 * @author  linzhiyu
 * @date  2020/2/20 15:02
 * @Email:1360482168@qq.com
 */

/*
思路：
1、front变量指向队首，front初始值为0，也就是arr[front]为队首的元素
2、rear变量指向队尾元素的后一个位置，因为希望留出一个空间。rear初始值为0。
3、当队列为空时。rear == front
4、当队列为满时 （rear + 1）%maxSize == front
,rear变量指向队尾元素的后一个位置,当队列为满时 rear + 1 就指向队首了。
5、队列中有效数据个数为，（rear - front + maxSize）% maxSize。
 */

import java.util.Scanner;
//测试数组模拟环形队列。
public class CircleQueue {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
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
class CircleArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    //创建队列的构造器
    public CircleArrayQueue(int arrMaxSize){
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;//指向队列头部，
        rear = 0;//指向队列尾部，指向队列的队尾的下一个位置。
    }
    //判断队列是否为满
    public boolean isFull(){
        return front == (rear + 1) % maxSize;
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
        //直接把数据加入
        arr[rear] = n;
        //rear后移一位
        rear = (rear + 1) % maxSize;
    }
    //数据出队列
    public int getQueue(){
        if (isEmpty()){
            //通过抛出异常处理。
            throw new RuntimeException("队列为空，不能获取数据\n");
        }
        int value = front;
        front = (front + 1) % maxSize;
        return value;
    }
    //显示数据
    public void showQueue(){
        //遍历
        if (isEmpty()){
            System.out.println("队列空，没有数据");
        }
        for (int i = front; i < front + queueSize() ; i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }
    //显示队列的头部数据，注意不是取出数据。
    public int headQueue(){
        //判断
        if (isEmpty()){
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front];
    }
    public int queueSize(){
        return (rear - front + maxSize) % maxSize;
    }



}
