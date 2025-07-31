class Solution {
    public static int floor(int[] nums,int target){
       int n = nums.length;
       int low=0;
       int high=n-1;
       int ans =-1;
       while(low<=high){
         int mid = low+(high-low)/2;
         if(nums[mid]==target){
            ans=mid;
            high=mid-1;;
         }
         else if(nums[mid]<target){
            low=mid+1;
         }
        else{
            high=mid-1;
        }
       }
       return ans;
    }
    public static int ceil(int[] nums,int target){
         int n = nums.length;
       int low=0;
       int high=n-1;
       int ans =-1;
       while(low<=high){
         int mid = low+(high-low)/2;
         if(nums[mid]==target){
            ans=mid;
            low=mid+1;
         }
         else if(nums[mid]<target){
            low=mid+1;
         }
         else{
            high=mid-1;
         }

       }
       return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int a = floor(nums,target);
        int b = ceil(nums,target);
        return new int[]{a,b};
    }
}