class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k=(int)1e9;
        int st=1;
        int end=0;
        for(int i=0;i<piles.length;i++){
            end=Math.max(end,piles[i]);
        }
        while(st<end){
            int mid=(end+st)/2;
            
            int temp=h;
            int check=Valid(piles,temp,mid);
            //System.out.println(st+" "+end+" "+mid+" "+check);
            
            if(check<0){
                st=mid+1;
            }else{
                k=Math.min(mid,k);
                end=mid;
            }
        }
        if(k==(int)1e9){
            return st;
        }
        return k;
    }
    public int Valid(int[] arr,int t,int k){
        for(int i=0;i<arr.length;i++){
          if(t<0){
            return -1;
          }
          if(k>=arr[i]){
            t--;
          }else{
            if(arr[i]%k==0){
                t=t-(arr[i]/k);
            }else{
            int quo=arr[i]/k;
            t=t-(1+quo);
            }
          }
        }
        return t;

    }
}