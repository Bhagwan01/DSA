class Solution {
    public int sortableIntegers(int[] nums) {
        int[] sorted=new int[nums.length];
        sorted=nums.clone();
        Arrays.sort(sorted);
        List<Integer> factors=new ArrayList<>();
        for(int i=1;i*i<=nums.length;i++){
            if(nums.length%i==0){
                factors.add(i);
                if(i!=nums.length/i){
                    factors.add(nums.length/i);
                }
            }
        }
        int ans=0;
        for(int a=0;a<factors.size();a++){
            int k=factors.get(a);
            boolean valid=true;
            for(int i=0;i<nums.length;i=i+k){
                int drop=0;
                int dropidx=-1;
                for(int j=0;j<k;j++){
                    int curr=nums[i+j];
                    int next=nums[i+(j+1)%k];
                    if(curr>next){
                        drop++;
                        dropidx=j;
                    }
                }
                if(drop>1){
                    valid=false;
                    break;
                }
                int offsetst=(drop==1)?(dropidx+1)%k:0;
                for(int j=0;j<k;j++){
                    if(nums[i+(j+offsetst)%k]!=sorted[i+j]){
                        valid=false;
                        break;
                    }
                }
                if(!valid){
                    break;
                }
            }
            if(valid){
                ans+=k;
            }
        }
        return ans;

    }
}