class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(0,temp,target,candidates,ans);
        return ans;
    }
    public void helper(int idx,List<Integer> list,int target,int[] candidates,List<List<Integer>> ans){
        if(target==0){
            List<Integer> temp=new ArrayList<>(list);
            ans.add(temp);
            return;
        }
        if(idx>=candidates.length){
            return;
        }
        list.add(candidates[idx]);
        if(target>=candidates[idx]){
            helper(idx,list,target-candidates[idx],candidates,ans);
        }
        list.remove(list.size()-1);
        helper(idx+1,list,target,candidates,ans);
    }
}