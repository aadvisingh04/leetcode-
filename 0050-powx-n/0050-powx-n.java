class Solution {
    public double myPow(double x, int n) {
        return power(x,(long)n);
    }
    private double power(double x, long n){
         if(n==0) return 1;

          if(n<0){
            return 1.0/power(x,-n);
          }
            if(n%2==1){  //if n is odd
              return x*power(x*x,(n-1)/2);
            }
            else{
                return power(x*x,n/2);  //n is even
            }
          }
    }
    
 