public class Array {
    private int [] data ;
    private int size;

    /**
     *构造函数，传入数组的容量 capacity 构造Array
     * @param capacity 容量
     */
    public Array(int capacity){
        data=new int[capacity];
        size=0;
    }

    /**
     * capacity： 容量
     * 无参数的构造函数，默认数组的容量capacity=10；
     */
    public Array(){
        this(10);
    }

    /**
     * 得到数组大小
     * @return size
     */
    public int getSize(){
        return  size;
    }

    /**
     * 得到数组容量
     * @return data.length
     */
    public  int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return boolean
     */
    public boolean isEmpty(){
        return  size==0;
    }
    public void addLast(int e){
//        if (size==data.length)
//            throw new IllegalArgumentException("AddLast failed.Array is full");
//        data[size]=e;
//        size++;
        add(size,e);
    }
   public void addFirst(int e){
        add(0,e);
   }
    /**
     * 在 index插入元素e
     * @param index 索引
     * @param e 元素
     */
    public void  add(int index,int e){
        if (size==data.length)
            throw new IllegalArgumentException("AddLast failed.Array is full");
        if (index<0|| index>size)
            throw new IllegalArgumentException("AddLast failed.Require index >=0 and index<=size");
        //元素后移
        for (int i=size-1;i>=size;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }
    /**
     *
     */
   public int get(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("Get failed.index is ");
        return data[index];
    }
   public void set(int index,int e){
        if (index<0||index>=size)
            throw new IllegalArgumentException("Get failed.index is ");
        data[index]=e;

    }

    /**
     * 数组是否包含了某个元素
     * @param e 元素
     * @return
     */
    public boolean contains(int e){
       for (int i=0;i<size;i++){
           if (data[i]==e)
               return true;
       }
       return false;
    }

    /**
     * 找到某个元素 返回元素的下标
     * @param e 元素
     * @return
     */
    public int find(int e){
       for (int i=0;i<size;i++){
           if (data[i]==e)
               return i;
       }
       return -1;
    }

    /**
     * 删除下标元素 并返回这个元素
     * @param index 数组下标
     * @return
     */
    public int remove(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("Get failed.index is ");
        int ret=data[index];
        for (int i=index+1;i<size;i++)
            data[i-1]=data[i];
        size--;
        return ret;
    }
    public int removeFirst(){
       return remove(0);
    }
    public int removeLast(){
        return  remove(size-1);
    }
    //删除指定元素..
    public void removeElement(int e){
        int index=find(e);
        if (index!=-1)
          remove(index);
    }
}
