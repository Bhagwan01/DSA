class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        for(int i=1;i<=n;i++){
            int one=dp[i-1];
            int two=0;
            if(i-2>=0){
                two=dp[i-2];
            }
            dp[i]=one+two;
        }
        return dp[n];
    }
    // public int helper(int n,int[] dp){
    //     if(n<0){
    //         return 0;
    //     }
    //     if(n==0){
    //         return 1;
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     int one=helper(n-1,dp);
    //     int two=helper(n-2,dp);
    //     return dp[n]=one+two;
    // }
}