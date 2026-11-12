class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc=1;
        int dec=1;
        Stack<Integer> st=new Stack<>();
        int temp=0;
        for(int i=0;i<nums.length;i++){
            if(!st.isEmpty()){
                if(st.peek()<nums[i]){
                    temp=st.size()+1;
                    inc=Math.max(inc,temp);
                }else{
                    while(!st.isEmpty()){
                        st.pop();
                    }
                    temp=0;
                }
            }
            st.push(nums[i]);
        }
        while(!st.isEmpty()){
            st.pop();
        }
        temp=0;
        for(int i=0;i<nums.length;i++){
            if(!st.isEmpty()){
                if(st.peek()>nums[i]){
                    temp=st.size()+1;
                    dec=Math.max(dec,temp);
                }else{
                    while(!st.isEmpty()){
                        st.pop();
                    }
                    temp=0;
                }
            }
            st.push(nums[i]);

        }
        return Math.max(inc,dec);
    }
}