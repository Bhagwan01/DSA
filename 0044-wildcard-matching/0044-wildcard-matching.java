class Solution {
    public boolean isMatch(String s, String p) {
       Boolean[][] dp=new Boolean[s.length()][p.length()];
       return helper(s.length()-1,p.length()-1,s,p,dp);


    }
    public boolean helper(int i,int j,String s,String p,Boolean[][] dp){
        if(j<0){
            return i<0;
        }
        if(i<0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        char sc=s.charAt(i);
        char pc=p.charAt(j);
        if(sc==pc || pc=='?'){
            return dp[i][j]=helper(i-1,j-1,s,p,dp);
        }
        if(pc=='*'){
            return dp[i][j]=helper(i-1,j,s,p,dp)||helper(i,j-1,s,p,dp);
        }
        return false;


    }
}