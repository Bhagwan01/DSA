class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(0,ans,temp,candidates,target);
        return ans;
    }
    public void helper(int idx,List<List<Integer>> ans,List<Integer> temp,int[] candidates,int target){
        if(target<0 || idx>=candidates.length){
            return;
        }
        if(target==0){
            List<Integer> copy=new ArrayList<>(temp);
            ans.add(copy);
            return;
        }
        temp.add(candidates[idx]);
        helper(idx,ans,temp,candidates,target-candidates[idx]);
        temp.remove(temp.size()-1);
        helper(idx+1,ans,temp,candidates,target);
    }
}