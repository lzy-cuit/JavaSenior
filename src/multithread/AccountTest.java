package multithread;

/**
 * @author linzhiyu
 * @date 2020/2/26 20:36
 * @Email:1360482168@qq.com
 * @Describe
 * 银行有一个账户
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次
 * 每次存完打印余额
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acc = new Account(0);
        Customer c1 = new Customer(acc);
        Customer c2 = new Customer(acc);
        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();

    }
}

class Account{
    private double balance = 0;
    public Account(double balance){
        this.balance = balance;
    }

    public Account() {

    }

    //存钱操作
    public synchronized void deposit(double amt){
        if (amt > 0){
            balance = balance + amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存钱成功。余额为： " + balance);
        }

    }

}
class Customer extends Thread{
    private Account account;
    public Customer(Account account){
        this.account = account;
    }
    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}


