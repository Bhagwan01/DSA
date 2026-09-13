class Solution {
    public long shadowPairs(int[] nums) {
        Stack<int[]> st=new Stack<>();
        long ans=0;
        long totalElement=0;
        for(int curr:nums){

           while(!st.isEmpty() && st.peek()[0]>curr){
            int[] pop=st.pop();
            totalElement-=pop[1];
           }

           long equalElement=0;
           if(!st.isEmpty() && st.peek()[0]==curr){
            equalElement=st.peek()[1];
           }

           long validPair=totalElement-equalElement;
           ans=ans+validPair;

           if(!st.isEmpty() && st.peek()[0]==curr){
            st.peek()[1]++;
           }else{
            st.push(new int[]{curr,1});
           }

           totalElement++;
        }
        return ans;

        
    }
}