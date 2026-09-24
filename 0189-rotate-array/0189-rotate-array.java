class Solution {
    public void rotate(int[] nums, int k) {
        if(k>=nums.length){
            k=k%nums.length;
        }
        nums=reverse(0,nums.length-k-1,nums);
        nums=reverse(nums.length-k,nums.length-1,nums);
        nums=reverse(0,nums.length-1,nums);
    }
    public int[] reverse(int st,int end,int[] nums){
        while(st<end){
            int temp=nums[st];
            nums[st]=nums[end];
            nums[end]=temp;
            st++;end--;
        }
        return nums;
    }
}