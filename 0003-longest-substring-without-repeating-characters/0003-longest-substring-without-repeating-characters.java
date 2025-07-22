import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxans = 0;
        int i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxans = Math.max(maxans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxans;
    }
}
/*import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
      int left =0;
      int maxL=0;
      HashSet<Character> set = new HashSet<>();

      for(int right=0;right<n;right++){
        while(set.contains(s.charAt(right))){
        set.remove(s.charAt(left));
        left++;
      }
      set.add(s.charAt(right));
      maxL = Math.max(maxL,right-left+1);
      }
      return maxL;
      
    }
} */