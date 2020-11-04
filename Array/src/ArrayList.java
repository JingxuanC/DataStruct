public class ArrayList<E> {
    private E[] data ;
    private int size;
     //支持泛型
    /**
     *构造函数，传入数组的容量 capacity 构造Array
     * @param capacity 容量
     */
    public ArrayList(int capacity){
        data=(E[]) new Object[capacity];
        size=0;
    }

    /**
     * capacity： 容量
     * 无参数的构造函数，默认数组的容量capacity=10；
     */
    public ArrayList(){
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
    public void addLast(E e){
//        if (size==data.length)
//            throw new IllegalArgumentException("AddLast failed.Array is full");
//        data[size]=e;
//        size++;
        add(size,e);
    }
   public void addFirst(E e){
        add(0,e);
   }
    /**
     * 在 index插入元素e
     * @param index 索引
     * @param e 元素
     */
    public void  add(int index,E e){
        if (size==data.length)
           resize(2*data.length);
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
   public E get(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("Get failed.index is ");
        return data[index];
    }
   public void set(int index,E e){
        if (index<0||index>=size)
            throw new IllegalArgumentException("Get failed.index is ");
        data[index]=e;

    }

    /**
     * 数组是否包含了某个元素
     * @param e 元素
     * @return
     */
    public boolean contains(E e){
       for (int i=0;i<size;i++){
           if (data[i].equals(e))
               return true;
       }
       return false;
    }

    /**
     * 找到某个元素 返回元素的下标
     * @param e 元素
     * @return
     */
    public int find(E e){
       for (int i=0;i<size;i++){
           if (data[i].equals(e))
               return i;
       }
       return -1;
    }

    /**
     * 删除下标元素 并返回这个元素
     * @param index 数组下标
     * @return
     */
    public E remove(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("Get failed.index is ");
       E ret=data[index];
        for (int i=index+1;i<size;i++)
            data[i - 1] = data[i];
        size--;
        data[size]=null;
        //缩容
        if(size==data.length/4&&data.length!=0)
            resize(data.length/2);
        return ret;
    }
    public E removeFirst(){
       return remove(0);
    }
    public E removeLast(){
        return  remove(size-1);
    }
    //删除指定元素
    public void removeElement(E e){
        int index=find(e);
        if (index!=-1)
          remove(index);
    }
    private void resize(int newCapacity){
        E[] newData=(E[]) new Object[newCapacity];
        for (int i=0;i<size;i++)
            newData[i]=data[i];
        data=newData;
    }
}
