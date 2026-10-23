class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        dp[n][m]=0;
        for(int j=0;j<=m;j++){
            dp[n][j]=word2.length()-j;
        }
        for(int i=0;i<=n;i++){
            dp[i][m]=word1.length()-i;
        }

        for(int i=word1.length()-1;i>=0;i--){
            for(int j=word2.length()-1;j>=0;j--){
                char w1=word1.charAt(i);
                char w2=word2.charAt(j);
                if(w1==w2){
                    dp[i][j]=dp[i+1][j+1];
                }else{
                 int del=1+dp[i+1][j];
                 int insert=1+dp[i][j+1];
                 int replace=1+dp[i+1][j+1];
                 dp[i][j]=Math.min(Math.min(del,insert),replace);
                }
            }
        }
        return dp[0][0];
    }
    public int helper(int i,int j,String word1,String word2,int[][] dp){
        if(i>=word1.length() && j>=word2.length()){
            return 0;
        }else if(i>=word1.length()){
            return (word2.length()-j);
        }else if(j>=word2.length()){
            return (word1.length()-i);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]=helper(i+1,j+1,word1,word2,dp);
        }
        int del=1+helper(i+1,j,word1,word2,dp);
        int insert=1+helper(i,j+1,word1,word2,dp);
        int replace=1+helper(i+1,j+1,word1,word2,dp);
        return dp[i][j]=Math.min(Math.min(del,insert),replace);
    }
}