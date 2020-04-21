package multithread;

/**
 * @author linzhiyu
 * @date 2020/2/26 21:54
 * @Email:1360482168@qq.com
 * @Describe
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p = new Producer(clerk);
        p.setName("生产者1");

        Consumer1 c = new Consumer1(clerk);
        c.setName("消费者1");

        p.start();
        c.start();


    }
}
class Clerk{
    private int num = 0;

    public synchronized void produceProduct() {
        if (num < 20){
            num++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + num + "个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumerProduct() {
        if (num > 0){
            System.out.println(Thread.currentThread().getName() + "开始消费第" + num + "个产品");
            num--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产。。。。");
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }


    }
}
class Consumer1 extends Thread{
    private Clerk clerk;

    public Consumer1(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费。。。。");
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumerProduct();
        }


    }

}
