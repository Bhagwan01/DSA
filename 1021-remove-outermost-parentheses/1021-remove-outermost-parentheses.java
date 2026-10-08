class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int open=0;
        for(int i=0;i<s.length();i++){
         char ch=s.charAt(i);
         if(ch=='('){
            open++;
            if(open>1){
                sb.append(ch);
            }
         }else{
            if(open>1){
                sb.append(')');
            }
            open--;
         }
         
        }
        return sb.toString();
    }
}