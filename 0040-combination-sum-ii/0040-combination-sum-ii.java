class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
       Arrays.sort(candidates);
        helper(0,temp,target,candidates,ans);
        return ans;
    }
    public void helper(int idx,List<Integer> list,int target,int[] candidates,List<List<Integer>> ans){
        if(target==0){
            List<Integer> temp=new ArrayList<>(list);
            ans.add(temp);
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            list.add(candidates[i]);
            helper(i+1,list,target-candidates[i],candidates,ans);
            list.remove(list.size()-1);
        }
    }
}