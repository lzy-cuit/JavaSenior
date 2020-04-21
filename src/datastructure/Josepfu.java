package datastructure;

/**
 * @author linzhiyu
 * @date 2020/3/30 4:06 下午
 * @Email:1360482168@qq.com
 * @Describe
 */
//约瑟夫问题
//    1、先构建一个环形链表。
//    2、环形链表一次性的添加完全部数据。
//    3、然后按照要求进行出圈操作
public class Josepfu {
    public static void main(String[] args) {
        SingleCircleLink singleCircleLink = new SingleCircleLink();
        singleCircleLink.addBoy(5);
        //singleCircleLink.showLink();

        //测试小孩出圈
        singleCircleLink.josepfuLink(1,2,5);
    }
}
//构建一个环形的单向链表
class SingleCircleLink{
    private Boy first = null;//创建一个头节点
    //构建一个具有nums个节点的环形链表
    public void addBoy(int nums){//nums表示添加boy的个数
        if (nums < 1){
            System.out.println("输入数据不合法");
            return;
        }
        Boy currenBoy = null;
        for (int i = 1; i <= nums; i++) {
            //根据编号创建节点
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                first.setNext(first);
                currenBoy = first;
            }else {
                currenBoy.setNext(boy);
                boy.setNext(first);
                currenBoy = boy;
            }
        }

    }
    //遍历当前链表
    public void showLink(){
        if (first == null){
            System.out.println("链表为null");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.println("小孩的编号为" + curBoy.getId());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    //小孩出圈的步骤
    /**
    * @Description:
    * @Param: [start 表示从第几个孩子开始数数,
     *          countNum 表示数几次开始出圈,
     *          nums 最初圈内的孩子数量]
     *
    * @return: void
    * @Author: linzhiyu
    * @Date: 2020/3/30
    */
    public void josepfuLink(int start,int countNum,int nums){
        if (start < 0 || start > nums || first == null){
            System.out.println("输入的数据有误，请重新输入");
        }
        Boy helper = first;
        //使得helper为first的后一个节点
        while (true){
           if (helper.getNext() == first){
               break;
           }
           helper = helper.getNext();
        }
        //把第一个节点移动到第一次数数的位置
        for (int i = 0; i < start-1; i++) {
            first = first.getNext();
            helper = helper.getNext();

        }
        while (true){
            if (helper == first){
                break;
            }
            //移动次数
            for (int i = 0; i < countNum - 1 ; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first就到了输出的位置
            System.out.printf("小孩%d出圈\n",first.getId());
            //小孩出圈后重新建立链接
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("圈内剩余小孩是" + first.getId());
    }
}

//创建一个boy class
class Boy{
    private int id;
    private Boy next;

    public Boy(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
