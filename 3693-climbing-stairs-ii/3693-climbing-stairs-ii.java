class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(0,costs,n,dp);
    }
    public int helper(int i,int[] costs,int n,int[] dp){
        if(i==n){
            return 0;
        }
        if(i>n){
            return (int)1e9;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int take1=(int) 1e9;
        if(i+1<=n){
            take1=costs[i+1-1]+1+helper(i+1,costs,n,dp);
        }
        int take2=(int) 1e9;
        if(i+2<=n){
            take2=costs[i+2-1]+4+helper(i+2,costs,n,dp);
        }
        int take3=(int) 1e9;
        if(i+3<=n){
            take3=costs[i+3-1]+9+helper(i+3,costs,n,dp);
        }
        return dp[i]=Math.min(Math.min(take1,take2),take3);
        
    }
}