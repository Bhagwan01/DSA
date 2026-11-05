class Solution {
    public int maxSubArray(int[] nums) {
        int temp=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=temp+nums[i]){
                temp=nums[i];
            }else{
                temp=temp+nums[i];
            
           } if(temp>=ans){
                ans=temp;
            }
        }
        return ans;

    }
}