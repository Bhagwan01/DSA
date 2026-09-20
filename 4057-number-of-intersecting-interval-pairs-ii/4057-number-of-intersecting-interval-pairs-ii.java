class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        long ans=0;
        for(int i=0;i<intervals.length;i++){
            int end=intervals[i][1];
            int left=i+1;
            int right=intervals.length-1;
            int max=i;
            while(left<=right){
                int mid=(right+left)/2;
                if(intervals[mid][0]<=end){
                    max=mid;
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            ans+=(max-i);
        }
        return ans;
    }
}