package multithread;

/**
 * @author linzhiyu
 * @date 2020/2/26 10:42
 * @Email:1360482168@qq.com
 * @Describe 创建2个分线程 ，一个遍历100以内的偶数
 *           一个遍历100以内的奇数。
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyTgread1 m1 = new MyTgread1();
        MyTgread2 m2 = new MyTgread2();
        m1.setName("线程1");
        m2.setName("线程2");
        m1.start();
        m2.start();
    }


}

class MyTgread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + " : " + i);

            }
        }
    }
}
class MyTgread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}