class Solution {
    public boolean isMatch(String s, String p) {
       Boolean[][] dp=new Boolean[s.length()][p.length()];
        return helper(s.length()-1,p.length()-1,s,p,dp);
    }
    public boolean helper(int i,int j,String s,String p,Boolean[][] dp){
        if(i==0 && j==0){
            if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='*'||p.charAt(j)=='?'){
                return true;
            }
            return false;
        }
        if(i<0 && j<0){
            return true;
        }
        if(i<0){
            while(j>0){
                if(p.charAt(j)=='*'){
                    j--;
                }else{
                    return false;
                }
            }
            if(j>=0 && p.charAt(j)=='*'){
                return true;
            }
            return false;
        }
        if(j<0){
            return false;
        }
        if(p.charAt(j)!='?' && p.charAt(j)!='*'&& s.charAt(i)!=p.charAt(j)){
            return false;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            return dp[i][j]=helper(i-1,j-1,s,p,dp);
        }
        return dp[i][j]=helper(i-1,j,s,p,dp)||helper(i,j-1,s,p,dp);

    }
}