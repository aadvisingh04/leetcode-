class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";

        String s = strs[0];
        int n = s.length();

        for(int i=1;i<strs.length;i++){
            String s1 = strs[i];

            while(n>s1.length() || !s.equals(s1.substring(0,n))){
                n--;
                if(n==0){
                    return "";
                }
                s = s.substring(0,n);
            }
        }
        return s;
    }
}