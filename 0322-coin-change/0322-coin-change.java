class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];

        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
        
        int ans= helper(coins.length-1,amount,coins,dp);
        if(ans==(int)1e9){
            return -1;
        }
        return ans;
    }
    public int helper(int idx,int amount,int[] coins,int[][] dp){
        if(amount==0 ){
            return 0;
        }
    if(amount<0 || idx<0 ){
        return (int)1e9;
    }
    if(dp[idx][amount]!=-1){
        return dp[idx][amount];
    }

     int pick=1+helper(idx,amount-coins[idx],coins,dp);
     int skip=helper(idx-1,amount,coins,dp);
     return dp[idx][amount]=Math.min(pick,skip);

    }
}