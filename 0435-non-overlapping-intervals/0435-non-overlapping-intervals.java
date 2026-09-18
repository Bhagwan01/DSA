class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        int st=intervals[0][0];
        int end=intervals[0][1];
        int ans=0;
        for(int i=1;i<intervals.length;i++){
            int currst=intervals[i][0];
            int currend=intervals[i][1];
            if(currst<end){
                ans++;
            }else{
                st=currst;
                end=currend;
            }
        }
        return ans;
    }
}