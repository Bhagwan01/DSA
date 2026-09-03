class Solution {
    public boolean canJump(int[] nums) {
        int i=0;
        while(i<nums.length){
            //System.out.println(nums[i]);
            if(i==nums.length-1){
                return true;
            }
            if(nums[i]==0){
                return false;
            }
            
            int j=i+1;
            int maxIdx=j;
            while(j<=i+nums[i]){
                // if(j>=nums.length){
                //     break;
                // }
                if(j==nums.length-1||nums[j]>=nums[i]){
                    i=j;
                    break;
                }
                if(nums[j]>=nums[maxIdx]){
                    maxIdx=j;
                }
                
                
                 if(j==i+nums[i] && j!=nums.length-1 && nums[j]==0){
                   i=maxIdx;
                }else if(j==i+nums[i]){
                    i=j;
                }
                j++;
            }
        }
        return true;
    }
}