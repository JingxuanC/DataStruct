import java.util.TreeMap;

public class Trie {
    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;
        public Node(boolean isWord){
            this.isWord=isWord;
            next=new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }
    private Node root;
    private int size;
    public Trie(){
        root=new Node();
        size=0;
    }
    //获得trie中存储的单词数量
    public int getSize(){
        return  size;
    }
    //添加一个单词
    public void add(String word){
        Node cur=root;
        for (int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if (cur.next.get(c)==null)
                cur.next.put(c,new Node());
            cur=cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }
    //查询单词是否存在
    public boolean contains(String word){
        Node cur=root;
        for (int i=0;i<word.length();i++){
            char c=word.charAt(i);
            //当前节点的映射是否包含该字符
            if (cur.next.get(c)==null)
                  return  false;
            //来到该字符所在节点
            cur=cur.next.get(c);
        }
        return  cur.isWord;
    }
    //查询sh是否在单词中以prefix为前缀
    public boolean isPrefix(String prefix){
        Node cur=root;
        for (int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            //当前节点的映射是否包含该字符
            if (cur.next.get(c)==null)
                return  false;
            //来到该字符所在节点
            cur=cur.next.get(c);
        }
        return  true;
    }
}
