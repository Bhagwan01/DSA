class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[][] dp=new Boolean[s.length()][s.length()];
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        for(int st=0;st<s.length();st++){
            if(set.contains(s.substring(st))){
                dp[st][s.length()-1]=true;
            }else{
                dp[st][s.length()-1]=false;

            }
        }
        for(int st=s.length()-1;st>=0;st--){
            for(int end=s.length()-2;end>=0;end--){
                boolean skip=false;
                boolean take=dp[st][end+1];
                if(end>=st && set.contains(s.substring(st,end+1))){
                    skip=dp[end+1][end+1];
                }
                dp[st][end]=take||skip;
            }
        }
        return dp[0][0];
    }
    // public boolean helper(int st,int end,String s,HashSet<String> dict,Boolean[][] dp){
    //     if(end==s.length()-1){
    //         if(dict.contains(s.substring(st,end+1))){
    //             return true;
    //         }
    //         return false;
    //     }
    //     if(dp[st][end]!=null){
    //         return dp[st][end];
    //     }
    //     boolean notPick=false;
    //     boolean pick=helper(st,end+1,s,dict,dp);
    //     if(dict.contains(s.substring(st,end+1))){
    //         notPick=helper(end+1,end+1,s,dict,dp);
    //     }
    //     return dp[st][end]=pick || notPick;
    // }
}