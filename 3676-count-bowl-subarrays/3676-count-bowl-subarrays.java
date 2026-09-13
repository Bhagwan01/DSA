class Solution {
    public long bowlSubarrays(int[] nums) {
        Stack<Integer> st=new Stack<>();
        long ans=0;
        long min=0;
        long max=0;
        long first=0;
        for(int curr:nums){
          
            
            while(!st.isEmpty() && st.size()>=2 && st.peek()<curr){
                 min=Math.min(first,curr);
                if(min>max){
                    ans++;
                }
                st.pop();
            }
              if(!st.isEmpty() && st.size()<2 && st.peek()<curr){
                st.pop();
            }
            if(!st.isEmpty()){
                max=curr;
            }          
           
            if(st.isEmpty()){
                first=curr;
            }
            st.push(curr);
        }
        return ans;
    }
}