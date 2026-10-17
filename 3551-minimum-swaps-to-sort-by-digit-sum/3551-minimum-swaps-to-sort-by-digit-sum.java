class Solution {
    public int minSwaps(int[] nums) {
        HashMap<Integer,Integer> map2=new HashMap<>();
        Integer[] arr=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr, (a, b) -> {
            int sumA = getDigitSum(a);
            int sumB = getDigitSum(b);
            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }
            return Integer.compare(a, b);
        });
        for(int i=0;i<arr.length;i++){
            map2.put(i,arr[i]);
        }
        int swap=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map2.get(i));
        }
        HashSet<Integer> visited=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            int curr=nums[i];
            if(!visited.contains(curr)){
                swap++;
                while(!visited.contains(curr)){
                    visited.add(curr);
                    curr=map.get(curr);
                }
            }
        }
       
        if(swap==0){
            return nums.length-1;
        }
        return nums.length-swap;

    }
    public int getDigitSum(int num){
        int sum=0;
        while(num>0){
        int temp=num%10;
        sum+=temp;
        num=num/10;
        }
        return sum;
    }
}