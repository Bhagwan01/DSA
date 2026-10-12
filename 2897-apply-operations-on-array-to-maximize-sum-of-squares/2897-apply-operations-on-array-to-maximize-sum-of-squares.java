class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] countOne=new int[32];
        long ans=0;
        int mod=1000000007;
        for(int i=0;i<nums.size();i++){
            int counter=0;
            int currNum=nums.get(i);
            while(counter<32){
                int isOne=(currNum)&1;
                if(isOne==1){
                    countOne[counter]++;
                }
                currNum=currNum>>1;
                counter++;
            }
        }
        while(k>0){
            long temp=0;
            for(int i=0;i<32;i++){
                if(countOne[i]!=0){
                  temp+=(int)Math.pow(2,i);
                  countOne[i]--;
                }
            }
            temp=(temp*temp)%mod;
            ans+=temp;
            k--;
        }
        ans=ans%mod;
        return (int)ans;
    }
}