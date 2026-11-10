class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int t1=(int)1e9;
            if(i+1<=n){
                t1=costs[i+1-1]+1+dp[i+1];
            }
            int t2=(int)1e9;
            if(i+2<=n){
                t2=costs[i+2-1]+4+dp[i+2];
            }
            int t3=(int)1e9;
            if(i+3<=n){
                t3=costs[i+3-1]+9+dp[i+3];
            }
            dp[i]=Math.min(Math.min(t1,t2),t3);
        }
        return dp[0];
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