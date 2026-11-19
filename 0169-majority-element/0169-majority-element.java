class Solution {
    public int majorityElement(int[] nums) {
        int ans=Integer.MAX_VALUE;
        int count=0;
        for(int num:nums){
            if(count==0){
                count++;
                ans=num;
            }else if(num==ans){
                count++;
            }else{
                count--;
            }
        }
        return ans;
    }
}