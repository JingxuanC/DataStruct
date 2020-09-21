

//循环队列的实现
public class LoopQueue<E> implements Queue<E>{
    private E[] data;
    private int size;//队列大小
    private int front,tail;//队尾和队头
    public LoopQueue(int capacity){
        data=(E[]) new Object[capacity-1];
        front=0;
        tail=0;
        size=0;
    }
    public LoopQueue(){
        this(10);
    }
    public int getCapacity(){
        return data.length-1;
    }
    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length==front)
          resize(getCapacity()*2);
        data[tail]=e;
        //循环队列。队尾后移
        tail=(tail+1)%data.length;
        size++;
    }

    private void resize(int newCapacity) {
        //循环队列 有个空间未使用，是用来存放 队尾的位置
        E[] newData=(E[])new Object[newCapacity+1];
        //拷贝
        for (int i=0;i<size;i++)
            //(i+front)%data.length 防止超出
            newData[i]=data[(i+front)%data.length];
        data=newData;
        front=0;
        tail=size;

    }
//出队
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("队列为空");
        E ret=data[front];
        //令  data[front] 引用为空
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if (size==getCapacity()/4 && getCapacity()/2!=0)
            resize(getCapacity()/2);
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("空");
        return data[front];
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Queue: size= %d ,capacity = %d \n",size,getCapacity());
        res.append("front [");
        for (int i=0;i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if ((i+1)%data.length!=tail)
                res.append(", ");
        }
        res.append("], tail");
        return res.toString();
    }

}
