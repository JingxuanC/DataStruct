import javax.swing.*;

/**
 * 基于二分搜索树实现映射
 */
public class BSTMap <K extends Comparable<K>,V> implements Map<K,V>{
    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public Node(K key,V value){
            this.key=key;
            this.value=value;
            right=null;
            left=null;
        }
    }
    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {
          root=add(root,key,value);
    }
    //向以node为根的二分搜索树中插入元素（可以，value）,递归算法
   // 返回插入新节点后二分搜索树的根
    private Node add(Node node,K key,V value){
          if (node==null){
              size++;
              return new Node(key,value);
          }
          if (key.compareTo(node.key)<0)
              node.left=add(node.left,key,value);
          if (key.compareTo(node.key)>0)
              node.right=add(node.right,key,value);
          else
              node.value=value;
          return node;
    }

    @Override
    public V remove(K key) {
        //得到被删除的节点
        Node node=getNode(root,key);
        if (node!=null){
            root=remove(root,key);
            return  node.value;
        }
        return null;
    }
    private Node remove(Node node,K key){
        if (node==null)
            return null;
        if (key.compareTo(node.key)<0){
             node.left=remove(node.left,key);
             return node;
        }
        if (key.compareTo(node.key)>0){
            node.right=remove(node.right,key);
            return node;
        }
        //找到待删除的节点
        else {
            //待删除节点左子树为空的情况
            if(node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空的情况
            if (node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
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
    public boolean contains(K key) {

        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
        Node node=getNode(root,key);
        return node==null? null:node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node=getNode(root,key);
        if (node==null){
            throw  new IllegalArgumentException("node is not exist");
        }
        node.value=value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    private Node getNode(Node node,K key){
        if (node==null)
            return null;
        if (key.compareTo(node.key)==0)
           return node;
        else if (key.compareTo(node.key)<0)
           return getNode(node.left,key);
        else
           return getNode(node.right,key);
    }
    //返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if (node.left==null)
            return node;

        return minimum(node.left);
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
}
