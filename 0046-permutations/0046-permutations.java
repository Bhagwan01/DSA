class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        helper(ans,set,list,nums);
        return ans;
    }
    public void helper(List<List<Integer>> ans,HashSet<Integer> set, List<Integer> list,int[] nums){
        if(list.size()==nums.length){
            List<Integer> temp=new ArrayList<>(list);
            ans.add(temp);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                list.add(nums[i]);
                set.add(nums[i]);
                helper(ans,set,list,nums);
                list.remove(list.size()-1);
                set.remove(nums[i]);
            }
        }
    }
}