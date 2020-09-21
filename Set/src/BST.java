import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;
        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    private Node root;
    private int size;

    public BST(){
        root=null;
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;

    }
    //添加元素
    public void add(E e){
        root= add(root,e);
        // size++;-->多加了一步 导致 整体错误
    }
    //向以node为根的二分搜索树中插入元素E,递归算法。
    private void add1(Node node,E e){
        if (e.equals(node.e))
            return ;
        else if (e.compareTo(node.e)<0&& node.left==null) {
            node.left = new Node(e);
            size++;
            return;
        }
        else if (e.compareTo(node.e)>0&& node.right==null){
            node.right=new Node(e);
            size++;
            return;
        }
        if (e.compareTo(node.e)<0)
            add1(node.left,e);
        else
            add1(node.right,e);
    }
    private Node add(Node node,E e){
        if (node==null){
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e)<0)
            node.left=add(node.left,e);
        else if (e.compareTo(node.e)>0)
            node.right=add(node.right,e);
        return node;
    }
    //查询 树中是否包含某种元素
    public boolean contains(E e){
        return contains(root,e);
    }
    //看以node为根的二分树是否包含元素 e
    private boolean contains(Node node, E e){
        if(node==null)
            return false;
        if (e.compareTo(node.e)==0)
            return true;
        else  if (e.compareTo(node.e)<0)
            return contains(node.left,e);
        else if (e.compareTo(node.e)>0)
            return contains(node.right,e);
        return false;
    }
    //非递归前序遍历
    public void preOrderNR(){
        Stack<Node> stack=new Stack<>();
        //将根节点压入栈中
        stack.push(root);
        while (!stack.isEmpty()){
            //栈顶是当前节点
            Node cur=stack.pop();
            //打印当前节点
            System.out.println(cur.e);
            //右节点不为空时，入栈
            if (cur.right!=null)
                stack.push(cur.right);
            //在左节点不为空时
            if (cur.left!=null)
                stack.push(cur.left);
        }
    }
    //遍历树结构----前序遍历
    public void preOrder(){
        preOrder(root);
    }
    //前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node){
        if (node==null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }
    //中序遍历
    public void inOrder(){
        inOrder(root);
    }
    //后续遍历
    public void aftOrder(){
        aftOrder(root);
    }
    private void aftOrder(Node node) {
        if (node==null)
            return;
        aftOrder(node.left);
        aftOrder(node.right);
        System.out.println(node.right);
    }
    private void inOrder(Node node){
        if (node==null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);

    }
    //层序遍历 广度优先遍历
    public void levelOrder(){
        Queue<Node> queue=new LinkedList<>();
        //根节点入队
        queue.add(root);
        while (!queue.isEmpty()){
            //当前节点
            Node cur=queue.remove();
            System.out.println(cur.e);
            if (cur.left!=null){
                //左节点入队
                queue.add(cur.left);
            }
            if (cur.right!=null)
                //右边节点入队
                queue.add(cur.right);
        }

    }
    //寻找二分搜索树的最小元素--->遍历左子树即可
    public E  minimum(){
        if (size==0)
            throw new IllegalArgumentException("BST is empty");
        Node minNode=minimum(root);
        return minNode.e;
    }
    //返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if (node.left==null)
            return node;

        return minimum(node.left);
    }
    //寻找二分搜索树的最大元素--->遍历左子树即可
    public E  maximum(){
        if (size==0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }
    //返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node){
        if (node.right==null)
            return node;
        return maximum(node.right);
    }
    //删除树种最小的节点
    public E removeMin(){
        E ret=minimum();
        root= removeMin(root);
        return ret;
    }
    //删除node为根的二分搜索树中的最小接节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if (node.left==null) {
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }

    //删除树种最小的节点
    public E removeMax(){
        E ret=minimum();
        root= removeMax(root);
        return ret;
    }
    //删除node为根的二分搜索树中的最大接节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        //右子树为null时，此时该节点的为最大值。也只有此时 才会进入if判断
        if (node.right==null) {
            Node leftNode=node.left;
            node.left=null;
            size--;
            //返回左子树
            return leftNode;
        }
        //返回出来的左子树 成为父节点的右子树
        node.right=removeMin(node.right);
        return node;
    }
    //删除书中的任意值
    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        //传入根节点和值
        root = remove(root, e);
    }

    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e){

        if( node == null )
            return null;
        //如果e小于节点的值
        if( e.compareTo(node.e) < 0 ){
            //在左子树中删除e
            node.left = remove(node.left , e);
            return node;
        }
        //如果e大于节点的值
        else if(e.compareTo(node.e) > 0 ){
            //在右子树中删除e
            node.right = remove(node.right, e);
            return node;
        }
        //e与当前节点的值相等时
        else{   // e.compareTo(node.e) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                //保存右子树
                Node rightNode = node.right;
                //右子树断开与树的关系
                node.right = null;
                //大小i减一
                size --;
                //返回右子树
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            // ***************
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置,当前节点的后继节点。
            //而这个后继节点就是被删除节点的右子树的最小值
            Node successor = minimum(node.right);
            //后继节点的右子树===等于  删除该后继节点后的子树-->即删除这个节点右子树的最小值剩下的子树的根节点。

            successor.right = removeMin(node.right);
            //后继节点的左子树等于被删除节点的左子树
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }





    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if (node==null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);


    }
    private String generateDepthString(int depth){
        StringBuilder res=new StringBuilder();
        for (int i=0;i<depth;i++)
            res.append("--");
        return res.toString();
    }
}
