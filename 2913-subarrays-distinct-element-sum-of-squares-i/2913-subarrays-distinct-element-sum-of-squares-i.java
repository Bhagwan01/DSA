class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans=0;
        for(int i=0;i<nums.size();i++){
            HashSet<Integer> set=new HashSet<>();
            set.add(nums.get(i));
            ans+=1;
            for(int j=i+1;j<nums.size();j++){
                if(!set.contains(nums.get(j))){
                    set.add(nums.get(j));
                }
                ans+=set.size()*set.size();
            }
        }
        return ans;
    }
}