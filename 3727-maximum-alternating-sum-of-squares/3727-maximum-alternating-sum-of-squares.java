class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                nums[i]=-nums[i];
            }
        }
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            if(i==j){
                ans+=1L*nums[i]*nums[i];
                break;
            }
            ans+=1L*nums[j]*nums[j];
            ans-=1L*nums[i]*nums[i];
            //System.out.println(ans);
            i++;j--;
        }
        return ans;
    }
}