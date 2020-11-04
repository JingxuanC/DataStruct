public class Solution {
    public static int fistUniqChar(String s) {

        int[] freq = new int[26];
        for (int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for (int i=0;i<s.length();i++)
            if (freq[s.charAt(i)-'a']==1)
                return i;
            return -1;
    }

    public static void main(String[] args) {
        String c="loveleetcode";
        System.out.println(fistUniqChar(c));
    }

}
