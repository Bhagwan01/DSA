class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] prefix=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        int ans=0;
        for(int i=0;i<prefix.length;i++){
            int temp=prefix[i]-k;
            if(map.containsKey(temp)){
                int val=map.get(temp);
                ans+=val;
            }
            if(map.containsKey(prefix[i])){
                map.put(prefix[i],map.get(prefix[i])+1);
            }else{
                map.put(prefix[i],1);
            }

        }
        return ans;
        
    }
}