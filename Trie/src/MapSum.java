import org.omg.CORBA.NO_IMPLEMENT;
import sun.util.resources.cldr.rof.CurrencyNames_rof;

import java.util.TreeMap;

public class MapSum {
    /** Initialize your data structure here. */
    private class Node{
        public int value;
        public TreeMap<Character, Node> next;
        public Node(int value){
            this.value=value;
            this.next=new TreeMap<>();
        }
        public Node(){
            this(0);
        }

    }
    private Node root;
    public MapSum(){
        root=new Node();
    }


    public void insert(String key, int val) {
       Node cur=root;
       for (int i=0;i<key.length();i++){
           char c=key.charAt(i);
           if (cur.next.get(c)==null)
               cur.next.put(c,new Node());
           cur = cur.next.get(c);
       }
       cur.value=val;
    }

    public int sum(String prefix) {
          Node cur=root;
          //找到前缀的最后一个节点
          for (int i = 0;i < prefix.length();i++){
              char c=prefix.charAt(i);
              if (cur.next.get(c)==null)
                  return 0;
              cur=cur.next.get(c);
          }
          //跳出循环的时候 cur就是前缀最后的一个字母所在的节点
          return sum(cur);
    }
    //以node为节点的所有子树的值
    private int sum(Node node){
        //叶子节点
        if (node.next.size()==0)
            return node.value;
        //当前节点的值
        int res=node.value;
        //遍历当前节点的所有子树对应的值
        for(char c : node.next.keySet()){
            res += sum(node.next.get(c));
        }
        return res;
    }
}
