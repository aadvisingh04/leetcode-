import java.util.*;

class Solution {
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
  public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];  // Result array
        
         for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            int smallestPrime = -1;   
             if ((num | 1) == 1) {
                smallestPrime = 1;
            } else {
               
                for (int p = 2; p < 1000; p++) {
                    if (isPrime(p) && (num | p) == p) {
                        smallestPrime = p;  
                           break; 
                    }
                }
            }
            
            ans[i] = smallestPrime; 
        }
        
        return ans;
    }
}