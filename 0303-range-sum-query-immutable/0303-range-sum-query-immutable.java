class NumArray {
    List<Integer> arr;
    public NumArray(int[] nums) {
        arr=new ArrayList<>();
        arr.add(nums[0]);
        for(int i=1;i<nums.length;i++){
          int next=nums[i]+arr.get(i-1);
          arr.add(next);
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0){
            return arr.get(right);
        }
        int a=arr.get(right);
        int b=arr.get(left-1);
        return a-b;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */