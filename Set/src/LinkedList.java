public class LinkedList<E> {
    //节点 私有内部类
    private class Node{
        public E e;
        public Node next;//下一个节点

        public Node(E e ,Node next){
            this.e=e;
            this.next=next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    //设置为虚拟头节点
    private Node dummyHead;
    private int size;
    public LinkedList(){
        dummyHead=new Node(null,null);
        size=0;
    }
    //获取链表个数
    public int getSize(){
        return size;
    }
    //链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //在链表index位置添加元素e
    public void add(int index,E e){
        if (index<0||index>size)
            throw new IllegalArgumentException("Add Failed,Illegal index");
            //prev先指向头节点
            Node prev=dummyHead;
            //找到要插入的位置的前一个节点
            for (int i=0;i<index;i++)
                //prev指向了下一个节点
                prev=prev.next;

//            Node node =new Node(e);
//            node.next=prev.next;
//            prev.next=node;
            prev.next=new Node(e,prev.next);
            size++;

    }
    //在链表头添加新的元素e
    public void addFirst(E e){
//        Node node=new Node(e);
//        node.next=head;
//        head=node;
        add(0,e);
    }
    //在链表末尾添加新的元素
    public void addLast(E e ){
        add(size,e);
    }
    //获得链表的第index个位置的元素
    public E get(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("index is Illegal");
        //当前节点
        Node cur=dummyHead.next;
        for (int i=0;i<index;i++)
            cur=cur.next;
        return cur.e;
    }
    //获得链表第一个元素
    public E getFirst(){
       return get(0);
    }
    //获得最后一个元素
    public E getLast(){
        return get(size-1);
    }
    //修改链表的第index 个的元素为e
    public void set(int index,E e){
        if (index<0||index>=size)
            throw new IllegalArgumentException(" set failed ;index is Illegal");
        Node cur=dummyHead.next;
        for(int i=0;i<index;i++)
            cur=cur.next;
        cur.e =e;
    }
    //查找链表中是否有元素e
    public boolean contains(E e){
        Node cur=dummyHead.next;
        while (cur!=null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }
    //删除一个节点
    public E remove(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException(" set failed ;index is Illegal");
        Node pre=dummyHead;
        for (int i=0;i<index;i++)
            pre=pre.next;
        Node retNode=pre.next;
        pre.next=retNode.next;
        retNode.next=null;
        size--;
        return retNode.e;
    }
    //删除第一个元素
    public E removeFirst(){
        return remove(0);
    }
    //删除最后一个元素
    public E removeLast(){
        return  remove(size-1);
    }
   //删除任意元素
    public void removeElement(E e){
        //从虚头节点开始
        Node prev=dummyHead;
        while (prev.next!=null){
            //找到被删除元素的前一个节点
            if (prev.next.e.equals(e))
                break;
            prev=prev.next;
        }
        if (prev.next!=null){
            //delNOde为即将被删除的节点
            Node delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
        }

    }
    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        Node cur=dummyHead.next;
        while (cur!=null){
            res.append(cur+"->");
            cur=cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
