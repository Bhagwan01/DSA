class Solution {
    public int minMoves2(int[] nums) {
        int ans=0;
        Arrays.sort(nums);
        int mid=nums.length/2;
        int element=nums[mid];
        for(int i=0;i<nums.length;i++){
            
            ans=ans+Math.abs(nums[i]-element);
        }
        return ans;
    }
}