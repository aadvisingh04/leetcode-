class Solution {
    public String triangleType(int[] nums) {
       int A = nums[0];
       int B = nums[1];
       int C = nums[2];
        
        if(A+B>C && B+C>A && A+C >B){
            if((A==B) && (B==C) && (C == A)){
                return "equilateral";
            }
            else if((A==B) || (B==C) || (C == A)){
                return "isosceles";
             }
            else {
                return "scalene";
             }
        }
           else{
            return "none";
        }
            }

}