class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String expres=tokens[i];
            if(expres.equals("+") || expres.equals("-") || expres.equals("*") || expres.equals("/")){
                int b=Integer.parseInt(st.pop());
                int a=Integer.parseInt(st.pop());
                int temp=0; 
                if(expres.equals("+")){
                    temp=a+b;
                }else if( expres.equals("-")){
                    temp=a-b;
                }else if(expres.equals("*")){
                    temp=a*b;
                }else{
                    temp=a/b;
                }
                String output=String.valueOf(temp);
                st.push(output);
            }else{
                 st.push(expres);
            }
        }
        int ans=Integer.parseInt(st.peek());
        return ans;
    }
}