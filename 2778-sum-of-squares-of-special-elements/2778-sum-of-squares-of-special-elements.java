class Solution {
    public int sumOfSquares(int[] nums) {
        int num=nums.length;
        int temp=0;
        for(int i=0;i<num;i++){
            if(num%(i+1)==0){
                temp+=nums[i]*nums[i];
            }
        }
        return temp;
    }
}