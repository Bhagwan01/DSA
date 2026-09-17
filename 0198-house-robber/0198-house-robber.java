class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
         for(int i=nums.length-1;i>=0;i--){
            int take=nums[i];
            int skip=0;
            if(i+2<nums.length){
                take=nums[i]+dp[i+2];
            }
            if(i+1<nums.length){
                skip=dp[i+1];
            }
            dp[i]=Math.max(take,skip);
         }
        return dp[0];
    }
    public int helper(int idx,int[] nums,int[] dp){
         if(idx>=nums.length){
            return 0;
         }
         if(dp[idx]!=-1){
            return dp[idx];
         }
        int take=nums[idx]+helper(idx+2,nums,dp);
        int skip=helper(idx+1,nums,dp);
        return dp[idx]=Math.max(take,skip);
    }
}