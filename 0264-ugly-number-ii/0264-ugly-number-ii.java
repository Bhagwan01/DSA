class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        HashSet<Long> set=new HashSet<>();
        long temp=1;
        pq.add(temp);
        long counter=0;
        long ans=1;
        long N=n;
        while(counter!=N){
            long curr=pq.poll();
            //System.out.prlongln(curr);
            ans=curr;
            long mul2=curr*2;
            long mul3=curr*3;
            long mul5=curr*5;
            if(!set.contains(mul2)){
                set.add(mul2);
                pq.add(mul2);
            } if(!set.contains(mul3)){
                set.add(mul3);
                pq.add(mul3);
            } if(!set.contains(mul5)){
                set.add(mul5);
                pq.add(mul5);
            }
            counter++;
        }
        return (int)ans;
        
    }
}