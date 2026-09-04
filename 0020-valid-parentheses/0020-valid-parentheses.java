class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            //System.out.println(ch);
            if(ch=='(' || ch=='[' || ch=='{'){
                st.push(ch);
            }
            if(ch==')'){
                if(st.isEmpty() || st.peek()!='('){
                    return false;
                }else{
                  st.pop();
                }
            }else if(ch==']'){
                if(st.isEmpty() || st.peek()!='['){
                    return false;
                }else{
                  st.pop();
                }

            }else if(ch=='}'){
                if(st.isEmpty() || st.peek()!='{'){
                    return false;
                }else{
                  st.pop();
                }

            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}