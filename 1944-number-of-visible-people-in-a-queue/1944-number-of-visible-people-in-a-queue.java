class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] ans=new int[heights.length];
        Stack<Integer> st=new Stack<>();
        // ans[heights.length-1]=0;
        // st.push(heights.length-1);
        for(int i=heights.length-1;i>=0;i--){
            int curr=heights[i];
            int count=0;
            if(!st.isEmpty() && curr>heights[st.peek()]){
                while(!st.isEmpty() && heights[st.peek()]<curr){
                    st.pop();
                    count++;
                }     
            }
            if(st.isEmpty()){
                ans[i]=count;
            }else{
                ans[i]=count+1;
            }
            st.push(i);
        }
        return ans;
    }
}