class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        int st=newInterval[0];
        int end=newInterval[1];
        int idx=0;
        for(int i=0;i<intervals.length;i++){
            int newst=intervals[i][0];
            int newed=intervals[i][1];
            if(newst>st || newed>=st){
                break;
            }
            list1.add(newst);
            list2.add(newed);
            idx++;
        }
        for(int i=idx;i<intervals.length;i++){
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
                if(newst<st){
                    st=newst;
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