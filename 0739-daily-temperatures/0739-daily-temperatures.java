class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int ans[]=new int[temperatures.length];
        Stack<Integer> st=new Stack<>();
        ans[temperatures.length-1]=0;
        st.push(temperatures.length-1);
        for(int i=temperatures.length-2;i>=0;i--){
            int temp=temperatures[st.peek()];
            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
                st.push(i);
                ans[i]=0;
            }else{
            int t=Math.abs(st.peek()-i);
            ans[i]=t;
            st.push(i);
            }
            
        }
        return ans;
    }
}