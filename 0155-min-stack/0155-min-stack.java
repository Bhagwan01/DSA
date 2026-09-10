class MinStack {
   int st;
   int arr[];
   int min[];
    public MinStack() {
        st=-1;
        arr=new int[30000];
        min=new int[30000];
    }
    
    public void push(int value) {
        st++;
        arr[st]=value;
        if(st==0){
            min[st]=value;
        }else{
            min[st]=Math.min(value,min[st-1]);
        }
    }
    
    public void pop() {
        st--;
    }
    
    public int top() {
        return arr[st];
    }
    
    public int getMin() {
        return min[st];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */