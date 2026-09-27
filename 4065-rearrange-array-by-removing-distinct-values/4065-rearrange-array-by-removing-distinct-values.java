class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans=new int[nums.length];
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        int idx=0;
        while(list.size()>0){
        List<Integer> temp=new ArrayList<>(list);
         System.out.println(list.size());
        for(int i=0;i<temp.size();i++){
         if(i==0){
            ans[idx]=temp.get(i);
            idx++;
            list.remove(Integer.valueOf(temp.get(i)));
            continue;
         }
         if(temp.get(i)==temp.get(i-1)){
            continue;
         }else{
            ans[idx]=temp.get(i);
            list.remove(Integer.valueOf(temp.get(i)));
            idx++;
         }
        }
       
        }
        return ans;
    }
}