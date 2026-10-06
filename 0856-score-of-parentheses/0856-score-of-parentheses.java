class Solution {
    public int scoreOfParentheses(String s) {
        int depth=0;
        int ans=0;
        //char ch='';
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                depth++;
            }else{
                depth--;
                if(s.charAt(i-1)=='('){
                    ans+=Math.pow(2,depth);
                }
            }
        }
        return ans;
    }
}