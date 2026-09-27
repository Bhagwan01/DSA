class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] freq=new int[101];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        int ans[]=new int[nums.length];
        int idx=0;
        while(idx<nums.length){
            for(int i=1;i<=100;i++){
                if(freq[i]>0){
                    ans[idx]=i;
                    idx++;
                    freq[i]--;
                }
            }
        }
        return ans;
    }
}