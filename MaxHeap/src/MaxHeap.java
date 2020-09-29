public class MaxHeap <E extends Comparable<E>>{
    private Array<E> data;
    public MaxHeap(int capacity){
        data=new Array<>(capacity);
    }
    public MaxHeap(){
        data=new Array<>();
    }
    public int size(){
        return data.getSize();
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }
    //得到当前节点的父节点的索引
    private int parent(int index){
        if (index==0)
            throw new IllegalArgumentException("Index is not");
        return (index-1)/2;
    }
    //得到当前节点的右孩子
    private int  rightChild(int index){
        return index*2+2;
    }
    //得到当前节点的左孩子
    private int leftChild(int index){
        return index*2+1;
    }
    //向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-2);
    }
    private void siftUp(int k){
        //data.get(parent(k)) 是当前节点的父亲元素  和当前元素做比较
        //若父亲小于还在则交换位置

        //直到k到达根节点或者 父节点大于子节点 结束循环
        while (k>0&&data.get(parent(k)).compareTo(data.get(k))<0){
                  data.swap(k,parent(k));
                  k=parent(k);
        }
    }
   //看一下堆中最大的元素
    public E findMax(){
        if (data.getSize()==0)
            throw new IllegalArgumentException("Can not finMax");
        return data.get(0);
    }
    //取出队中的元素
    public E extractMax(){
        E e=findMax();
        //最大元素和最小元素交换位置
        data.swap(0,data.getSize()-1);
        //删除最后一个元素  此时是最大的那个元素
        data.removeLast();
        siftDown(0);
        return e;
    }
    private void siftDown(int k){
        //当前节点的左孩子的索引值小于数组的大小
        //循环到叶子节点
        //左孩子的索引 小于数组大小？
        while (leftChild(k)<data.getSize()){
            int j=leftChild(k);// 在此轮循环中,data[k]和data[j]交换位置
            if (j+1<data.getSize()&&
                    //右孩子大于左孩子
                    data.get(j+1).compareTo(data.get(j))>0) {
                j = rightChild(k);//右孩子下标
            }
            // data[j] 是 leftChild 和 rightChild 中的最大值
            if(data.get(k).compareTo(data.get(j)) >= 0 )
                break;

            data.swap(k, j);
            k = j;
        }
    }
}
