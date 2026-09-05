class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> heap=new PriorityQueue<>((x,y)->Integer.compare(y[1],x[1]));
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
        if(map.containsKey(nums[i])){
            int val=map.get(nums[i]);
            map.put(nums[i],val+1);
        }else{
            map.put(nums[i],1);
        }
        }
        map.forEach((key,value)->{
            heap.add(new int[]{key,value});
        });
        int ans[]=new int[k];
        int i=0;
        while(k>i){
            int[] curr=heap.poll();
            ans[i]=curr[0];
            i++;
        }
        return ans;

    }
}