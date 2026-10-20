class Solution {
    public int sortableIntegers(int[] nums) {   
        List<Integer> factors=new ArrayList<>();
        int[] sorted=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            sorted[i]=nums[i];
        }
        Arrays.sort(sorted);
        for(int i=1;i*i<=nums.length;i++){
           if(nums.length%i==0){
            factors.add(i);
             if (i != nums.length / i) {
            factors.add(nums.length/ i);
        }
           }
          
        }
        int ans=0;
        
        for(int b=0;b<factors.size();b++){
            int k=factors.get(b);
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

             int offsetStart=(drop==1)?(dropidx+1)%k:0;

             for(int j=0;j<k;j++){
               if(nums[i+(j+offsetStart)%k]!=sorted[i+j]){
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