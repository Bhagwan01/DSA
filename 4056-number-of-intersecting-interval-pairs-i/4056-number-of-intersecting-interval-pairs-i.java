class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int ans=0;
        for(int i=0;i<intervals.length;i++){
            int st=intervals[i][0];
            int end=intervals[i][1];
            for(int j=i+1;j<intervals.length;j++){
                int currst=intervals[j][0];
                int currend=intervals[j][1];
                if(currst<=end){
                    ans++;
                }
            }
        }
        return ans;
    }
}