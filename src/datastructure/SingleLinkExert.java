package datastructure;

/**
 * @author linzhiyu
 * @date 2020/2/24 11:43
 * @Email:1360482168@qq.com
 * @Describe
 */

public class SingleLinkExert {
    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(1,"姚明","男");
        LinkNode node2 = new LinkNode(2,"科比","男");
        LinkNode node3 = new LinkNode(3,"易建联","男");
        LinkNode node4 = new LinkNode(4,"娜可露露","女");
        LinkNode node5 = new LinkNode(5,"佟丽娅","女");
        LinkNode node6 = new LinkNode(6,"姚笛","女");

        LinkNode node7 = new LinkNode(6,"111","女11");


        //创建链表对象
        SingleLink singleLink = new SingleLink();
        singleLink.addNode(node1);
        singleLink.addNode(node3);

        singleLink.addNode(node6);
        singleLink.insertNode(node4);
        singleLink.showList();
//        System.out.println("*********");
//        System.out.println(getLength(singleLink.getHead()));
//        System.out.println(showIndexNode(singleLink.getHead(),4));
//        reverseLink(singleLink.getHead());


        System.out.println("*********");

        recurrentLink(singleLink.getHead());
//        singleLink.showList();

    }
    /**
     * 反向打印链表的数据
     */
    public static void reversePrint(LinkNode head){

        LinkNode temp = head.next;
        if (temp != null){
            reversePrint(temp);
        }
        if (temp != null){
            System.out.println(temp);
        }
    }


    /**
     * 使用递归反转单链表
     */
    public static LinkNode recurrentLink(LinkNode head){

        if (head == null || head.next.next == null){
            return head;
        }
        LinkNode temp = head.next;

        LinkNode re = recurrentLink(temp);
        temp.next.next = head;
        head.next = null;
        return re;
    }






    /**
     * @Author linzhiyu
     * @Date 2020/2/24 21:43
     * @Description
     * @Param [head]
     * @Return void
     * @Since version-1.0
     */
    public static void reverseLink(LinkNode head){

        if (head.next == null || head.next.next == null){
            System.out.println("不需要反转");
        }
        LinkNode newNode = new LinkNode(0,"","");
        LinkNode temp = head.next;
        LinkNode next = null;
        while (temp != null){
            next = temp.next;
            temp.next = newNode.next;
            newNode.next = temp;
            temp = next;
        }
        head.next = newNode.next;
    }
    /**
     * 查找链表的倒数第k个节点。显示节点信息
     */
    public static LinkNode showIndexNode(LinkNode head,int index){
        if (head.next == null){
            System.out.println("链表为空");
        }

        LinkNode temp = head.next;
        int size = getLength(head);
        if (index < 0 || index > size){
            System.out.println("输入的数据不合法");
        }

        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    /**
     * 求链表中的有效节点个数、不包含头节点。
     */
    public static int getLength(LinkNode head){
        int length = 0;
        if (head.next == null){
            System.out.println("链表为空");
        }
        LinkNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            if (temp != null){
                length++;
                temp = temp.next;
            }

        }
        return length;

    }


}

/**
 * 包含了对单链表的添加节点、删除节点、修改节点、查找节点功能。
 */
class SingleLink{
    private LinkNode head = new LinkNode(0,"","");

    public LinkNode getHead(){
        return head;
    }

    /**
     * 添加节点到单链表的末尾
     *
     */
    public void addNode(LinkNode linkNode){
        LinkNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = linkNode;

    }
    /**
     * 按照一定的顺序添加节点到链表中(插入节点)
     */
    public void insertNode(LinkNode linkNode){
        LinkNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.id > linkNode.id){
                break;
            }else if (temp.next.id == linkNode.id){
                System.out.println("节点已经存在");
            }
            temp = temp.next;

        }
        linkNode.next = temp.next;
        temp.next = linkNode;
    }
    /**
     * 修改节点数据，根据节点的id为索引
     */
    public void changeNode(LinkNode linkNode){
        LinkNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.id == linkNode.id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = linkNode.name;
            temp.sex = linkNode.sex;
        }else {
            System.out.println("没有找到数据：");
        }
    }
    /**
     * 删除节点数据，按照节点id为索引。
     */
    public void deleteNode(LinkNode linkNode){
        LinkNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.id == linkNode.id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        try {
            if (flag){
                temp.next = temp.next.next;
            }else {
                System.out.println("删除的节点不存在：");
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }


    }
    /**
     * 查看指定id的节点信息
     */
    public void showNode(int i){
        LinkNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.id == i){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println(temp);
        }else {
            System.out.println("节点id为" + i + "的节点不存在");
        }
    }
    /**
     * 遍历链表的数据
     */
    public void showList(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        LinkNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}



class LinkNode{
    public int id;
    public String name;
    public String sex;
    public LinkNode next;

    public LinkNode() {
    }

    public LinkNode(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
