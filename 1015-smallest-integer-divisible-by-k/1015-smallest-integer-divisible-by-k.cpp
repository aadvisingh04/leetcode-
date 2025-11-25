class Solution {
public:
    int smallestRepunitDivByK(int k) {
        if(k%2 == 0 || k%5 == 0) return -1;
        
        long long int res=0;
        for(int i=1;i<=k;i++){
            res = res*10+1;
            if(res%k == 0) return i;           
            
        }
        return -1;
    }
};



/*k -> smallest +ve integer(n)


1
11
111
1111
11111
111111   

means even k ke liye to -1 hi hoga */
