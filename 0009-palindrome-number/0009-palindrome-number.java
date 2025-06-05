class Solution {
    public boolean isPalindrome(int x) {
        int n = x, rev = 0;
        if(x<0){
        return false;
        }
        while(x!=0){
            int m = x%10;
            rev = (rev*10) + m;
            x = x/10;
        }
       
        return rev==n;
    }
}