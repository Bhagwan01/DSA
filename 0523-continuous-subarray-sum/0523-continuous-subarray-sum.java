class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] prefix=new int[nums.length+1];
        prefix[0]=0;
        if(nums.length==1){
            return false;
        }
        HashMap<Integer,Integer> map=new HashMap<>(); 
        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        map.put(0,0);
        for(int i=1;i<prefix.length;i++){
            int remain=prefix[i]%k;
            //System.out.println(remain);
            if(map.containsKey(remain)){
                int val=map.get(remain);
                int diff=i-val;
                if(diff>=2){
                    return true;
                }
            }else{
                map.put(remain,i);
            }
        }
        return false;
    }
}