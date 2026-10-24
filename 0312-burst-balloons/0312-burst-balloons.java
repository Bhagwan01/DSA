class Solution {
    public int maxCoins(int[] nums) {
        int[] ballons=new int[nums.length+2];
        int[][] dp=new int[nums.length+2][nums.length+2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                dp[i][j]=-1;
            }
        }
        ballons[0]=1;
        for(int i=0;i<nums.length;i++){
            ballons[i+1]=nums[i];
        }
        ballons[nums.length+1]=1;
        return helper(1,nums.length,ballons,dp);
    }
    public int helper(int i,int j,int[] nums,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int temp=nums[i-1]*nums[k]*nums[j+1]+helper(i,k-1,nums,dp)+helper(k+1,j,nums,dp);
            if(temp>=ans){
                ans=temp;
            }
        }
        return dp[i][j]=ans;
    }

}