
public class LinkedListStack<E> implements Stack<E> {
    private LinkList<E> list;

    public LinkedListStack() {
        list = new LinkList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addLast(e);
    }

    //从栈元素取去头部元素
    @Override
    public E pop() {
        return list.removeFirst();
    }

    //得到栈的第一个元素
    @Override
    public E peek() {
        return list.getFirst();
    }


    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("stack: Top");
        res.append(list);
        return res.toString();
    }
}
