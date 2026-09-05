class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
         for(int i=0;i<coins.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                int pick=(int)1e9;
                int skip=(int)1e9;
                if(j-coins[i]>=0){
                    pick=1+dp[i][j-coins[i]];
                }
                if(i-1>=0){
                    skip=dp[i-1][j];
                }
                dp[i][j]=Math.min(pick,skip);
                
            }
        }
        if(dp[coins.length-1][amount]==(int)1e9){
            return -1;

        }
        return dp[coins.length-1][amount];
        
    }
    // public int helper(int idx,int amount,int[] coins,int[][] dp){
    //     if(amount==0 ){
    //         return 0;
    //     }
    // if(amount<0 || idx<0 ){
    //     return (int)1e9;
    // }
    // if(dp[idx][amount]!=-1){
    //     return dp[idx][amount];
    // }

    //  int pick=1+helper(idx,amount-coins[idx],coins,dp);
    //  int skip=helper(idx-1,amount,coins,dp);
    //  return dp[idx][amount]=Math.min(pick,skip);

    // }
}