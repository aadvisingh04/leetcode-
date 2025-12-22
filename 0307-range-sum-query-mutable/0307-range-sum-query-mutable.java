class NumArray {
    static int[] segTree;
    static int n;
    static int[] arr;
    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4*n];
        arr = Arrays.stream(nums).toArray();
        build(0, 0, n-1);
    }
    public static void build(int i, int l, int r){
        if(l == r){
            segTree[i] = arr[l];
            return;
        }
        int mid = (l+r)/2;

        build(2*i+1, l, mid);
        build(2*i+2, mid+1, r);

        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }
    
    public void update(int index, int val) {
        real_update(0, 0, n-1, index, val);
    }

    public void real_update(int i, int l, int r, int targetIdx, int val){
        if(l == r){
            segTree[i] = val;
            return;
        }
        int mid = (l+r)/2;
        if(targetIdx <= mid) real_update(2*i+1,l,mid,targetIdx,val);       
        else real_update(2*i+2,mid+1,r,targetIdx,val);

        segTree[i] = segTree[2*i+1] + segTree[2*i+2];
    }
    
    public int sumRange(int s, int e) {
        return sum_range(0, 0, n-1, s, e);
    }

    public int sum_range(int i, int l, int r, int s, int e){
        //not in range
        if(s>r || e<l) return 0;

        //in range
        if(l >= s && r <= e) return segTree[i];

        //overlap
        int mid = (l+r)/2;
        int leftS = sum_range(2*i+1,l,mid,s,e);
        int rightS = sum_range(2*i+2,mid+1,r,s,e);

        return leftS+rightS;
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */