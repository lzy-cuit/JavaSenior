package multithread;

/**
 * @author linzhiyu
 * @date 2020/2/26 21:06
 * @Email:1360482168@qq.com
 * @Describe
 * 线程通信的例子
 * 使用两个线程打印1-100  线程1 线程 2 交替打印
 */
public class commucationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();


    }
}
class Number implements Runnable{
    private int number = 1;

    @Override
    public void run() {
        while (true){
            //使用同步代码块的方式解决线程安全
            synchronized (this){
                //唤醒被wait（）阻塞的线程。
                // 如果有多个线程被阻塞，就唤醒优先级高的线程
                notify();
            if (number <= 100){
                try {
                    //使得线程睡眠100毫秒
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;

                //使得调用wait（）方法的线程进入阻塞状态，并释放同步监视器
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }else {
                break;
            }
            }
        }
    }
}
