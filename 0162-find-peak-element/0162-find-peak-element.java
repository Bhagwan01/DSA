class Solution {
    public int findPeakElement(int[] nums) {
        int st=0;
        int end=nums.length-1;
        if(nums.length==1){
            return 0;
        }
        while(st<end){
            int mid=(st+end)/2;
            if(mid==0 && nums[mid+1]<nums[mid] || mid==nums.length-1 && nums[mid-1]<nums[mid]){
                return mid;
            }
            if(mid+1<nums.length && mid-1>=0 && nums[mid+1]<nums[mid] && nums[mid-1]<nums[mid] ){
                return mid;
            }
                if(mid+1<nums.length && nums[mid+1]>nums[mid]){
                    st=mid+1;
                }else if(mid-1>=0 && nums[mid-1]>nums[mid]){
                    end=mid-1;
                }
            
        }
        return st;
    }
}