class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max=nums[0];
        int currMax=nums[0];
        int min=nums[0];
        int currMin=nums[0];
        int total=nums[0];
        for(int i=1;i<nums.length;i++){
            currMax=Math.max(currMax+nums[i],nums[i]);
            max=Math.max(max,currMax);

            currMin=Math.min(currMin+nums[i],nums[i]);
            min=Math.min(min,currMin);
            total+=nums[i];
        }
        int circularMax=total-min;
        if(circularMax==0){
            return max;
        }
        return Math.max(max,circularMax);
    }
}