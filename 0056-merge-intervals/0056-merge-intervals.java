class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        int st=intervals[0][0];
        int end=intervals[0][1];
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
         int newst=intervals[i][0];
         int newed=intervals[i][1];
         if(newst>end){
            list1.add(st);
            list2.add(end);
            st=newst;
            end=newed;
         }else{
            if(newed>end){
                end=newed;
            }
         }
        }
        list1.add(st);
        list2.add(end);
        int[][] ans=new int[list1.size()][2];
        for(int i=0;i<list1.size();i++){
            ans[i][0]=list1.get(i);
            ans[i][1]=list2.get(i);
        }
        return ans;
    }
}