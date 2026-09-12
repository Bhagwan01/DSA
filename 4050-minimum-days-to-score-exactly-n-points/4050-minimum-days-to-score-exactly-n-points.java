class Solution {
    public int minDays(int n) {
        int[] arr=new int[n+1];
        int[] dp=new int[n+1];
        if(n==1){
            return 1;
        }
        for(int i=0;i<=n;i++){
            int temp=(i*(i+1))/2;
             arr[i]=temp;
             dp[i]=-1;
        }
        return helper(arr,n,dp);
    }
    public int helper(int[] arr,int n,int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int min=Integer.MAX_VALUE;
        int idx=1;
        while(arr[idx]<=n){
            int days=idx;
            if(n-arr[idx]>0){
                days=days+1+helper(arr,n-arr[idx],dp);
            }
            min=Math.min(min,days);
            idx++;
        }
        return dp[n]=min;
    }
}