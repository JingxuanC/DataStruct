import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst=new BST<>();
        Random random=new Random();
//        int[] nums={5,4,3,2,7,6,8,11};
//        for (int num: nums)
//            bst.add(num);
//        bst.levelOrder();
       // System.out.println(bst);
	// write your code here
        int n=6;
        for (int i=0;i<n;i++){
            bst.add(random.nextInt(50));
        }
        System.out.println(bst.size());
        ArrayList<Integer> nums=new ArrayList<>();
        int b=0;
        while (!bst.isEmpty())
            b=bst.removeMin();
            nums.add(b);
        System.out.println(nums);
    }
}
