class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer> set=new HashMap<>();
        int prefix[]=new int[nums.length+1];
        prefix[0]=0;
        //set.put(0,1);
        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        for(int i=0;i<=nums.length;i++){
            int sum=prefix[i]-k;
            if(set.containsKey(sum)){
                count+=set.get(sum);
                
            }
            if(set.containsKey(prefix[i])){
                set.put(prefix[i],set.get(prefix[i])+1);
            }else{
                set.put(prefix[i],1);
            }
        }
        return count;

        
    }
}