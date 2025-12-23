class Solution {
    static int[] seg;
    static int n;

    static void build(int[] heights,int i, int l, int r){
        if(l == r){
            seg[i] = l;
            return;
        }
        int mid = (l+r)/2;
        build(heights,2*i+1,l,mid);
        build(heights,2*i+2,mid+1,r);
        
        int left = seg[2*i+1];
        int right = seg[2*i+2];

        seg[i] = (heights[left] >= heights[right] ? left : right);
    }
    
    static int query(int[] heights,int i, int l, int r, int s, int e){
        if(s > r || e < l) return -1;
        if(s <= l && e >= r) return seg[i];

        int mid = (l+r)/2;

        int left = query(heights,2*i+1,l,mid,s,e);
        int right = query(heights,2*i+2,mid+1,r,s,e);

        if(left == -1) return right;
        if(right == -1) return left;

        return (heights[left] >= heights[right] ? left : right);
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        n = heights.length;
        seg = new int[4*n];
        build(heights,0,0,n-1);
        
        int[] ans = new int[queries.length];
        int idx=0;

        for(int[] query : queries){
            int minIdx = Math.min(query[0],query[1]);
            int maxIdx = Math.max(query[0],query[1]);

            if(minIdx == maxIdx){
               ans[idx] = minIdx;
               idx++;
            }
            else if(heights[maxIdx] > heights[minIdx]){
                ans[idx] = maxIdx;
                idx++;
            }
            else{
                int l = maxIdx+1;
                int r = n-1;
                int resIdx = Integer.MAX_VALUE;

                while(l <= r){
                    int mid = l + (r - l) / 2;
                    int index = query(heights,0,0,n-1,l,mid);

                    if(heights[index] != -1 && heights[index] > Math.max(heights[maxIdx],heights[minIdx])){
                        resIdx = Math.min(resIdx, index);
                        r = mid - 1;
                    }
                    else{
                        l = mid + 1;
                    }

                }
                ans[idx] = (resIdx == Integer.MAX_VALUE) ? -1 : resIdx;
                idx++;
            }
        }
        return ans;
        
    }
}