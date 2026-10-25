class Solution {
    public long maximizeSum(int[] nums, int k) {
        long sum=0;
        long[] arr=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            char[] chArr=String.valueOf(nums[i]).toCharArray();
            Arrays.sort(chArr);
            long newNum=0;
            for(int j=chArr.length-1;j>=0;j--){
                newNum=newNum*10+(chArr[j]-'0');
            }
            arr[i]=newNum-nums[i];
        }
        Arrays.sort(arr);
        for(int i=arr.length-1;i>=0 && k>0;i--,k--){
            sum+=arr[i];
        }
        return sum;
    }
}