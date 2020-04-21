package datastructure.tree.binaryTree;

/**
 * @author linzhiyu
 * @date 2020/4/12 3:33 下午
 * @Email:1360482168@qq.com
 * @Describe
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node node1 = new Node(1, "宋江");
        Node node2 = new Node(2, "吴用");
        Node node3 = new Node(3, "卢俊义");
        Node node4 = new Node(4, "林冲");
        //创建一颗二叉树
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        binaryTree.setRoot(node1);
        System.out.println("前序遍历为：");
        binaryTree.preOrder();
        System.out.println("前序查找：");
        Node node = binaryTree.preOrderSearch(4);
        System.out.println(node);
    }
}

/**
* @Description: 创建一个二叉树
* @Param:
* @return:
* @Author: linzhiyu
* @Date: 2020/4/12
*/
class BinaryTree{
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public void midOrder(){
        if (this.root != null){
            this.root.midOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public void backOrder(){
        if (this.root != null){
            this.root.backOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }


    /**
     * 前序查找
     */
    public Node preOrderSearch(int id){
        if (root != null){
            return root.proSearch(id);
        }else {
            return null;
        }
    }


}
/**
* @Description: 构建一个树型节点
* @Param:
* @return:
* @Author: linzhiyu
* @Date: 2020/4/12
*/
class Node{
    private int id;
    private String name;
    private Node left;
    private Node right;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    /**
     *  前序遍历函数
     */
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
    /**
     *  中序遍历函数
     */
    public void midOrder(){

        if (this.left != null){
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.midOrder();
        }
    }
    /**
     *  后序遍历函数
     */
    public void backOrder(){

        if (this.left != null){
            this.left.backOrder();
        }
        if (this.right != null){
            this.right.backOrder();
        }
        System.out.println(this);
    }
    /**
     * 前序查找
     */
    public Node proSearch(int id){
        //判断当前节点
        if (this.id == id){
            return this;
        }
        //左子树遍历
        Node node = null;
        if (this.left != null){
            node = this.left.proSearch(id);
        }
        if (node != null){
            return node;
        }
        //右子树遍历
        if (this.right != null){
            node = this.right.proSearch(id);
        }
        return node;

    }

}
