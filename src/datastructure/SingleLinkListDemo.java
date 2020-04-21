package datastructure;
/*
 * @author  linzhiyu
 * @date  2020/2/20 17:23
 * @Email:1360482168@qq.com
 * @Describe 1、创建一个链表，只有顺序添加数据功能。
             2、 按照顺序插入数据到链表。
             3、删除链表的数据。
             4、修改链表的数据。
             5、几个单链表的面试题
 */

import java.util.Stack;

/**
1、实现步骤：
    1、先创建节点对象，成员变量表示链表节点里面保存的数据和next指针。
    2、创建链表类。用来进行对节点的操作，比如添加节点。
2、实现步骤：
    1、先遍历链表，找到要插入的数据的位置，也就是找到插入数据的后一个位置。
    2、修改链表的的指针，HeroNode.next = temp.next
                      temp.next = HeroNode
3、实现步骤：
    1、通过遍历先找到要修改的节点，temp.next.id == id
    2、删除节点操作，temp.next = temp.next.next
 * @author linzhiyu

 */
public class SingleLinkListDemo {
    public static void main(String[] args) {
        //先创建几个节点
        HeroNode hero1 = new HeroNode(1, "你大爷", "你大爷");
        HeroNode hero2 = new HeroNode(2, "你大爸", "你大爸");
        HeroNode hero3 = new HeroNode(3, "你大哥", "你大哥");
        HeroNode hero4 = new HeroNode(4, "你弟弟", "你弟弟");
        //创建链表
        SingleLinkList singleLinkList = new SingleLinkList();
//        //加入数据
//        singleLinkList.addNode(hero1);
//        singleLinkList.addNode(hero2);
//        singleLinkList.addNode(hero3);
//        singleLinkList.addNode(hero4);
        //按照顺序添加顺序
        singleLinkList.insertNode(hero1);
        singleLinkList.insertNode(hero2);
        singleLinkList.insertNode(hero3);
        singleLinkList.insertNode(hero4);
        //显示链表的数据
        singleLinkList.showList();
        System.out.println("**************");

////        //测试从尾到头打印链表的数据
////        reversePrint(singleLinkList.getHead());
//        //测试反转链表的数据
//        reverseList(singleLinkList.getHead());
//        singleLinkList.showList();
        System.out.println("***************************************");
        getNext(singleLinkList.getHead());
//
//        //测试修改节点数据
//        HeroNode hero = new HeroNode(2,"2","2");
//        singleLinkList.changeNode(hero);
//        //显示链表的数据
//        singleLinkList.showList();
//        //删除一个节点
//        singleLinkList.del(1);
//        System.out.println("删除后链表的情况");
//        singleLinkList.showList();
    }

    /**
    从尾到头打印单链表【百度面试题】
    1、第一种思路  使用单链表的反转，然后在正常的打印链表
    2、利用栈的特性，先进先出的特性，先把数据压入栈中，然后在弹出来。
     */
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            return;//表示栈为空
        }
        //先创建一个栈，将各节点压入栈中
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null){
            //将节点压入栈中
            stack.push(cur);
            //将节点压入栈中
            cur = cur.next;
        }
        while (stack.size() > 0) {
            //栈的特点先进后出
            System.out.println(stack.pop());
        }

    }
    /**
    单链表的反转【腾讯面试题】
    思路：1、先定义一个新的头节点 newHeadNode
         2、遍历旧的链表的数据
         3、依次从头取出每一个节点，然后插入到新的链表的头节点
         4、把原来头节点指向新链表的第一个有效节点
     */
    public static void reverseList(HeroNode head){
        //如果链表为空  或者只有一个节点就不用反转
        if (head.next == null || head.next.next == null){
            return ;
        }
        //定义一个辅助的指针，帮住我们遍历原来的链表
        HeroNode cur = head.next;
        //指向当前节点[cur]的下一个节点
        HeroNode next = null;
        //新建立的一个头节点，帮助我们进行反转
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历链表的数据，遍历一个就把数据放在新的头节点下面。
        while (cur != null){
            //先保存当前节点的下一个节点
            next = cur.next;
            //先保存当前节点的下一个节点
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            //已数据。经反转了所有链表的
            cur = next;
        }
        //将原来的头节点指向现在反转后的链表的第一个数据
        head.next = reverseHead.next;

    }
    public static HeroNode findIndexNode1(HeroNode head){
        return head.next;

    }

    /**
     * 使用递归函数来进行反向列表打印
     * @param head
     */
    public static void getNext(HeroNode head){
        HeroNode node = head.next;
        if(node!=null){
            getNext(node);
        }
        if (node != null) {
            System.out.println(node);
        }
    }



    /**
     查找链表的倒数第k个节点。【新浪面试题】
     思路：
     1、编写一个方法，接收head节点，同时接收一个index（表示链表的倒数第index个节点）
     2、遍历链表，得到链表的长度length
     3、得到长度后，再一次的遍历链表，（length- index）也就是倒数第k个节点
     4、找到了就返回节点信息，没有找到就返回null
     */
    public static HeroNode findIndexNode(HeroNode head,int index){
        if (head.next == null){
            return null;
        }
        int length =  getLength(head);
        if (index < 0 || index > length){
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < length - index; i++) {
            temp = temp.next;
        }
        return temp;

    }
    /**
     * 得到链表的有效长度
     * @param head 表示传入链表的头节点
     * @return length 链表的长度
     */
    public static int getLength(HeroNode head){
        int length = 0;
        if (head.next == null){
            System.out.println("链表为空");
        }
        HeroNode temp = head.next;
        while (true){
            if (temp != null){
                length++;
                temp = temp.next;

            }
            return length;
        }

    }


}



/**
 * 定义LinkList来管理我们的节点对象。
 */

class SingleLinkList{

    private HeroNode head = new HeroNode(0,"","");


    public HeroNode getHead() {
        return head;
    }
    /**
    添加节点到单向链表（顺序加入节点到链表中）
    1、找到当前链表的最后节点。
    2、将最后这个节点的next指向新的节点。
     */
    public void addNode(HeroNode heroNode){
        //因为头节点不能动，因此我们需要一个辅助遍历变量temp
        HeroNode temp = head;
        //遍历链表,找到链表的尾部。也就是temp.next== null
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    //添加节点。（按照节点中存在的顺序）
    public void insertNode(HeroNode heroNode){
        //因为头节点不能动，所以就只能通过辅助变量来找到指定插入的位置。
        HeroNode temp = head;
        boolean flag = false;
        //遍历列表
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.id > heroNode.id){
                break;
            }else if (temp.next.id == heroNode.id){
                flag = true;
            }
            temp = temp.next;
        }
        //判断flag值
        if (flag){
            System.out.println("添加的数据已经存在");
        }
        heroNode.next = temp.next;
        temp.next = heroNode;

    }
    //删除节点
    public void del(int id){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            //到达链表末尾
            if (temp.next == null){
                break;

            }
            if (temp.next.id == id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == true){
            temp.next = temp.next.next;
        }
    }

    /**
     *  遍历链表,也是需要辅助链表。
     */

    public void showList(){
        if (head.next == null){
            System.out.println("列表为空");
            return;
        }
        //因为头节点不能动，所以也是需要一个辅助节点用来记录当前节点信息的。H
        HeroNode temp = head.next;
        while (true){
            //判断是否到了链表的末尾，
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
    /**
     * 修改节点信息，根据节点编号。
     */
    public void changeNode(HeroNode heroNode){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //根据节点编号，找到要修改的节点
        //定义辅助变量
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;//遍历结束
            }
            if (temp.id == heroNode.id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag = true){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }else {
            //没有找到数据
            System.out.println("没有找到编号为" + heroNode.id + "的节点");
        }

    }






}


/**
 * 先定义一个节点对象。
 */

class HeroNode{
    public int id;
    public String name;
    public String nickName;
    public HeroNode next;





    public HeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }
    /**
     *  为了显示方便，从写toString方法。
     */

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

}