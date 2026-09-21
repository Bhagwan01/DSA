class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        dp[m-1][n-1]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                
            if(i==m-1 && j==n-1){
                continue;
            }else{
                   int right=dp[i+1][j];
                   int  down=dp[i][j+1];
                    dp[i][j]=down+right;
        
            }
                
            }
        }
        return dp[0][0];
    }
    public int helper(int row,int col,int m,int n,int[][] dp){
        if(row==m-1 && col==n-1){
            return 1;
        }
        if(row<0 || row>=m || col<0 || col>=n){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int down=helper(row+1,col,m,n,dp);
        int right=helper(row,col+1,m,n,dp);
        return dp[row][col]=down+right;
    }
}