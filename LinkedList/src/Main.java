import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Integer> map =new HashMap<>();

    int opCount=100000;
    ArrayStack<Integer> arrayStack=new ArrayStack<>();
    double time1=testStack(arrayStack,opCount);
    System.out.println("ArrayStack:"+time1);
    LinkedListStack<Integer> listStack=new LinkedListStack<>();
    double time2=testStack(listStack,opCount);
    System.out.println("LinkedListStack:"+time2);
    System.out.println(time1-time2);
    }
    private static double testStack(Stack<Integer> q, int opCount){
        long startTime =System.nanoTime();
        Random random=new Random();
        for (int i=0;i<opCount;i++)
            q.push(random.nextInt(Integer.MAX_VALUE));
        for (int i1=0;i1<opCount;i1++)
            q.pop();

        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void testLinkList(){
        LinkList<Integer> linkList=new LinkList<>();
        for (int i=0;i< 5;i++) {
            linkList.addFirst(i);
            System.out.println(linkList);
        }
        linkList.add(3,66);
        System.out.println(linkList);
        linkList.remove(2);
        System.out.println(linkList);
        linkList.addFirst(3);
        System.out.println(linkList);
        linkList.addLast(21);
        System.out.println(linkList);
        linkList.remove(5);
        System.out.println(linkList);
        linkList.removeFirst();
        System.out.println(linkList);
        linkList.removeLast();
        System.out.println(linkList);
    }
    public static void testArray() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 6; i++) {
            stack.push(i);
            System.out.println(stack);
        }
    }
    public static void testLinkedListStack(){
        LinkedListStack<Integer> listStack=new LinkedListStack<>();
        for (int i=0;i<7;i++){
            listStack.push(i);
            System.out.println(listStack);
        }
    }
    }

