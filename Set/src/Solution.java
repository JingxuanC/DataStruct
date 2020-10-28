import java.util.TreeSet;

/**
 * 摩尔斯 算法题
 */
public class Solution {
    public int uniqueMorseRepresentation(String [] words){
        String[] codes={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set=new TreeSet<>();
        for (String word:words){
            StringBuilder res=new StringBuilder();
            for (int i=0;i<word.length();i++){
                //word.charAt(i)-'a'  是Acills码的计算
                res.append(codes[word.charAt(i)-'a']);
                set.add(res.toString());
            }
        }
        return set.size();
    }
}
