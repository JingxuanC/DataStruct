import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int [] nums={1, 2, 3, 2, 2, 2, 5, 4, 2};
        majorityElement(nums);
        
    }
    public static int majorityElement(int[] nums) {
        int k=nums.length/2;
        int max=0;
        int kes=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            map.put(nums[i],1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>max){
                max=map.get(key);
                kes=key;
            }
        }

        return kes;

    }
}
