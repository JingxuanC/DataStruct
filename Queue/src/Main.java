import java.util.Random;

public class Main {
  private static double testQueue(Queue<Integer> q, int opCount){
      long startTime =System.nanoTime();
      Random random=new Random();
      for (int i=0;i<opCount;i++)
          q.enqueue(random.nextInt(Integer.MAX_VALUE));
      for (int i1=0;i1<opCount;i1++)
          q.dequeue();

      long endTime=System.nanoTime();
      return (endTime-startTime)/1000000000.0;
  }
  public static void main(String[] args) {
	// write your code here
//        int opCount=100000;
//        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>();
//        double time1=testQueue(arrayQueue,opCount);
//        System.out.println("ArrayQueue"+time1);
//        LoopQueue<Integer> loopQueue=new LoopQueue<>();
//        double time2=testQueue(loopQueue,opCount);
//        System.out.println("LoopQueue"+time2);
      int [] arr={1,2,3};
      int sum=sum(arr,0);
      System.out.println(sum);
    }
    /**
     * 递归求和
     */
    public static int sum(int [] arr,int l){
        if (l==arr.length)
            return 0;
        int a=arr[l]+sum(arr,l+1);
        return a;
    }
}
