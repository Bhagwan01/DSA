class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[]=new int[nums.length];
        ans[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            ans[i]=nums[i+1]*ans[i+1];
           // System.out.println(i+" "+ans[i]);
        }
        int temp=1;
        ans[0]=ans[0]*temp;
        for(int i=1;i<nums.length;i++){
           temp=nums[i-1]*temp;
           ans[i]=ans[i]*temp;
        }
        return ans;
    }
}