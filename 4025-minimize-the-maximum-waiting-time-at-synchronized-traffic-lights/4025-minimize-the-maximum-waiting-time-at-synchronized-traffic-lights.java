class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int ans=0;
        int max=lights[0];
        for(int i=0;i<lights.length;i++){
            max=Math.max(max,lights[i]);
        }

        for(int i=0;i<arrivalTime.length;i++){
            
            int r=arrivalTime[i]%period;
            if(r<max){
                ans=Math.max(0,ans);
            }else{
                ans=Math.max(ans,period-r);
            }
        }
        return ans;
    }
}

