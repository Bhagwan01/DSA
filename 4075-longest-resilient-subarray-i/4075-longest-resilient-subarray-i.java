class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            int y=nums[i]%k;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(nums[j]%k!=y){
                    break;
                }
                if(sum%k==y){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}