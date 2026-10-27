class Solution {
    public boolean canJump(int[] nums) {
        int next=nums[0];
        for(int i=1;i<nums.length;i++){
            if(i>next){
            return false;
         }
            next=Math.max(next,i+nums[i]);
        }
        return true;
    }
}