class Solution {
    public int minMoves(int[] nums) {
        int max=(int)-1e9;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            ans=ans+(max-nums[i]);
        }
        return ans;
    }
}