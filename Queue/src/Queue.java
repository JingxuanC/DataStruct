public interface Queue <E>{
    boolean isEmpty();
    int getSize();
    //入队
    void enqueue(E e);
    //出队
    E dequeue();
    E getFront();
}
