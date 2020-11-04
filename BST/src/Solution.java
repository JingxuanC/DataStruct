import java.util.ArrayList;
import java.util.List;

public class Solution {
    public  static  int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        int i=0;
        int j=i+k-1;
        int max=0;
        while(j<nums.length){
            for(int m=i;m<i+k;m++){
                max=Math.max(max,nums[m]);
            }
            i++;
            j=i+k-1;
            list.add(max);
        }
        int [] res=new int[list.size()];
        for(int n=0;n<res.length;n++){
            res[n]=list.get(n);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
       System.out.println(maxSlidingWindow(nums,k).toString());
    }
}
