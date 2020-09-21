public interface Stack<E> {
    boolean isEmpty();
    void push(E e);
    int getSize();
    E pop();
    E peek();

}
