/*class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
           map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)-1); 
        }
        for(int val:map.values()){
            if(val!=0) return false;
        }
        return true;
    }
}*/
import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        // Case 1: Lengths must be equal
        if (s.length() != t.length()) return false;

        // Convert strings to char arrays and sort them
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        // Compare sorted arrays
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) return false;
        }

        return true;
    }
}
