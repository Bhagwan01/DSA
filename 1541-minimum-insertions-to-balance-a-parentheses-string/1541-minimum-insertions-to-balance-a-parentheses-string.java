class Solution {
    public int minInsertions(String s) {
        int min=0;
        Stack<Character> st=new Stack<>();
        int close=0;
        for(int i=0;i<s.length();i++){
             char ch=s.charAt(i);
            if(ch=='('){
                if(!st.isEmpty() && st.peek()==')'){
                    st.pop();
                    st.pop();
                    min+=1;
                }
                st.push(ch);
                if(close==1){
            min+=2;
            close=0;
        }else{
            if(close%2==0){
                min+=close/2;
            }else{
                min+=(close/2)+2;
            }
            close=0;
        }
            }else {
                if(!st.isEmpty() && st.peek()=='('){
                    st.push(ch);
                }else if(!st.isEmpty() && st.peek()==')'){
                    st.pop();
                    st.pop();
                }
                else{
                    close++;
                }
            } 
        }
        while(!st.isEmpty()){
            if(st.peek()=='('){
                min+=2;
            }else{
                min+=1;
                st.pop();
            }
            st.pop();
        }
        if(close==1){
            min+=2;
        }else{
            if(close%2==0){
                min+=close/2;
            }else{
                min+=(close/2)+2;
            }
        }
        
        
        
        return min;

    }
}   