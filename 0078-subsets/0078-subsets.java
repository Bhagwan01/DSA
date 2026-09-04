class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(ans,0,nums,temp);
        return ans;
    }
    public void helper(List<List<Integer>> ans,int idx,int[] nums,List<Integer> temp){
        if(idx>=nums.length){
            List copy=new ArrayList<>(temp);
            ans.add(copy);
            return;
        }
        temp.add(nums[idx]);
        helper(ans,idx+1,nums,temp);
        temp.remove(temp.size()-1);
        helper(ans,idx+1,nums,temp);
    }
}