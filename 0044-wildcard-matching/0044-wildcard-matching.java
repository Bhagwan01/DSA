class Solution {
    public boolean isMatch(String s, String p) {
       boolean[][] dp=new boolean[s.length()+1][p.length()+1];
       dp[0][0]=true;
       for(int j=1;j<=p.length();j++){
        if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
       }
       for(int i=1;i<=s.length();i++){
        for(int j=1;j<=p.length();j++){
            char sc = s.charAt(i-1);
        char pc = p.charAt(j-1);
        if (sc == pc || pc == '?') {
             dp[i][j] = dp[i-1][j-1];
        }
        else if (pc == '*') {
             dp[i][j] = dp[i-1][j]|| dp[i][j-1];
        }else{
            dp[i][j]=false;
        }
        
        }
       }
       
       return dp[s.length()][p.length()];
    }

    public boolean helper(int i, int j, String s, String p, Boolean[][] dp) {
        if (j < 0) {
            return i < 0;
        }
        if (i < 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        char sc = s.charAt(i);
        char pc = p.charAt(j);
        if (sc == pc || pc == '?') {
            return dp[i][j] = helper(i - 1, j - 1, s, p, dp);
        }
        if (pc == '*') {
            return dp[i][j] = helper(i - 1, j, s, p, dp) || helper(i, j - 1, s, p, dp);
        }
        return false;

    }
}