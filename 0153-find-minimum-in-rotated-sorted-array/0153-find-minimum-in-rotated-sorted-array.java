class Solution {
    public int findMin(int[] nums) {
        int st=0;
        int end=nums.length-1;
        int min=Integer.MAX_VALUE;
        while(st<=end){
         int mid=(st+end)/2;
         if(nums[st]<=nums[mid]){
            if(nums[st]<min){
                min=nums[st];
            }
            st=mid+1;

         }else{
            if(nums[mid]<min){
                min=nums[mid]; 
            }
            end=mid-1;

         }
         
        }
        return min;
    }
}