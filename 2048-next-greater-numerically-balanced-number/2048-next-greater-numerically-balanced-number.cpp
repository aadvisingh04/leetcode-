class Solution {
public:
    int nextBeautifulNumber(int n) {
        for(int i=n+1;;i++){
            
            int temp=i;
            map<int,int> mp;
            while(temp!=0){
                int r=temp%10;
                mp[r]++;
                temp/=10;
            }

            //check
            bool f=true;
            for(auto &m:mp){
                if(m.first!=m.second){
                    f=false;
                    break;
                }
            }

            if(f==true) return i;
        }
        return n;
    }
};