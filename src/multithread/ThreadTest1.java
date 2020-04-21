package multithread;

/**
 * @author linzhiyu
 * @date 2020/2/26 16:35
 * @Email:1360482168@qq.com
 * @Describe
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        Mythread1 m = new Mythread1();
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        Thread t3 = new Thread(m);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Mythread1 implements Runnable{
    private int ticket = 100;
    Object obj = new Object();
    @Override
    public void run() {
       while (true){
           synchronized (obj){
           if(ticket > 0){
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName() + " : 卖票 票号为" + ticket );
                ticket--;
           }else {
               break;
           }
           
       }
    }
}
}
