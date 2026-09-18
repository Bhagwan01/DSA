class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[1],b[1]);
        });
        
        int end=intervals[0][1];
        int ans=0;
        for(int i=1;i<intervals.length;i++){
            int currst=intervals[i][0];
            int currend=intervals[i][1];
            if(currst<end){
                ans++;
            }else{
                end=currend;
            }
        }
        return ans;
    }
}