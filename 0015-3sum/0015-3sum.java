class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0 ){
                break;
            }
            int first=nums[i];
           
            int target=0;
            if(first!=0){
                target=-first;
            }
            
            int j=i+1;
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int k=nums.length-1;
            boolean flag=false;
            while(j<k){
                int sum=nums[j]+nums[k];
                if(sum==target){
                List<Integer> list=new ArrayList<>();
                list.add(first);
                list.add(nums[j]);
                list.add(nums[k]);
                ans.add(list);
                j++;
                k--;
                while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                }else if(sum<target){
                    j++;
                }else{
                    k--;
                }
            }
            

        }
        return ans;
    }
   
}