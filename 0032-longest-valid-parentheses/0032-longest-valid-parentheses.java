class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int maxLen = 0;
        int currLen = 0;
        int n = s.length();
        for(int i = 0; i<n; i++){
            char bracket = s.charAt(i);
            if(bracket == ')'){
                if(stk.isEmpty()) currLen = 0;
                else{
                    int lenTillNow = stk.peek();
                    stk.pop();
                    currLen+= lenTillNow+2;
                    maxLen = Math.max(maxLen,currLen);
                }
            }
            else{
                stk.push(currLen);
                currLen = 0;
            }
        }
        return maxLen;
    }
}