class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        
        for(int i=0;i<nums.length;i++){
            int res=target-nums[i];
            if(map.containsKey(res)){
                int idx=map.get(res);
                if(idx==i){
                    continue;
                }
                ans[0]=i;
                ans[1]=idx;
                break;
            }
        }
        return ans;
    }
}