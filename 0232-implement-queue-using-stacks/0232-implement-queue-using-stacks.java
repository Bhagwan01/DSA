class MyQueue {
    Stack<Integer> st;
    Stack<Integer> temp;

    public MyQueue() {
        st=new Stack<>();
        temp=new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        int ans=-1;
        while(!st.isEmpty()){
            temp.push(st.pop());
        }
        if(!temp.isEmpty()){
            ans=temp.pop();
        }
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
        return ans;
    }
    
    public int peek() {
        int ans=-1;
        while(!st.isEmpty()){
            temp.push(st.pop());
        }
        if(!temp.isEmpty()){
            ans=temp.peek();
        }
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
        return ans;
        
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */