class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length+1;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,-1,nums,dp);
    }
    public int helper(int idx,int prev,int[] nums,int[][] dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx][prev+1]!=-1){
            return dp[idx][prev+1];
        }
        int take=0;
        if(prev==-1){
            take=1+helper(idx+1,idx,nums,dp);
        }else{
          if(nums[idx]>nums[prev]){
            take=1+helper(idx+1,idx,nums,dp);
          }
        }
        int skip=helper(idx+1,prev,nums,dp);
        return dp[idx][prev+1]=Math.max(skip,take);
    }
}