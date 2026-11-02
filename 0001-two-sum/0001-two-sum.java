class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int num=target-nums[i];
            if( map.containsKey(num) && i!=map.get(num)){
                list.add(map.get(num));
                list.add(i);
                map.remove(nums[i]);
            }
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}