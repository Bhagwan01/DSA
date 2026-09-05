class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i=0;i<nums.length;i++){
            heap.add(nums[i]);
        }
        int ans=-1;
        while(k>0){
            ans=heap.poll();
            k--;

        }
        return ans;
    }
}