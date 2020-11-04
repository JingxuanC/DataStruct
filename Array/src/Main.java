import java.util.ArrayList;
import java.util.List;

public class Main {
/**
 * 数组最大的优点：快速查询
 * 数组最好应用于“索引有语义”的情况
 */


    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
	//声明一个数组
        int [] arr=new int[10];
        for(int i=0;i<arr.length;i++){
            arr[i]=i;
        }
        //声明的时候就初始化
        int [] scores=new int[]{100,99,88};
        for (int i:scores){
            System.out.println(i);
        }
    }
}
