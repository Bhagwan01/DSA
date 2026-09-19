class Solution {
    public int findMaxLength(int[] nums) {
        int[] prefix=new int[nums.length+1];
        int ans=0;
        prefix[0]=0;
         for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[i]=-1;
            }
            prefix[i+1]=prefix[i]+nums[i];
         }
         HashMap<Integer,Integer> map=new HashMap<>();
         map.put(0,-1);
        
         for(int i=0;i<prefix.length-1;i++){
            if(map.containsKey(prefix[i+1])){
                ans=Math.max(ans,i-map.get(prefix[i+1]));
            }else{
                map.put(prefix[i+1],i);
            }
         }
         return ans;
    }
}