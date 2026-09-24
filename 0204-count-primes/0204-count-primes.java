class Solution {
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        boolean[] nums=new boolean[n];
        int prime=0;
        
        for(int i=2;i*i<n;i++){
            if(!nums[i]){
                for(int j=i*i;j<n;j+=i){
                    nums[j]=true;
                }
            }
        }
        for(int i=2;i<n;i++){
            if(!nums[i]){
                prime++;
            }
        }
        return prime;
        

    }
}