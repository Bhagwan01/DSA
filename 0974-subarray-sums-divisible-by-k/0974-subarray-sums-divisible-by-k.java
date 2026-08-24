class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] prefix=new int[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
         int ans=0;
        for(int i=0;i<prefix.length;i++){
            int remainder=prefix[i]%k;
            remainder=remainder+k;
            remainder=remainder%k;
            if(map.containsKey(remainder)){
                int val=map.get(remainder);
                ans+=val;
                map.put(remainder,val+1);
            }else{
                map.put(remainder,1);
            }
        }
        // for(Map.Entry<Integer,Integer> entry: map.entrySet()){
        //     ans+=entry.getValue(); 
        // }
        return ans;

    }
    
}    