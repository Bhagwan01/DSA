class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int ans=0;
        int[] prefix=new int[nums.length];
        prefix[0]=nums[0];
        int remainder[]=new int[nums.length];
        remainder[0]=nums[0]%k;
        for(int p=1;p<nums.length;p++){
            prefix[p]=prefix[p-1]+nums[p];
            remainder[p]=nums[p]%k;
        }
        int i=0;
        int j=0;
        while(j<nums.length){
            int sum=(i==0)?prefix[j]:prefix[j]-prefix[i-1];
            if(remainder[i]==remainder[j]){
                if(sum%k==remainder[i]){
                    ans=Math.max(ans,j-i+1);
                }
                j++;
            }else{
                i=j;
            }
        }
        return ans;
    }
}