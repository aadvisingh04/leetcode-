class Solution {
    public String largestOddNumber(String num) {
        char[] arr = num.toCharArray();
        int n = arr.length;

        for(int i=n-1;i>=0;i--){
            if((arr[i]-'0') % 2 != 0){
               return num.substring(0,i+1);
            }
        }
        return "";
    }
}