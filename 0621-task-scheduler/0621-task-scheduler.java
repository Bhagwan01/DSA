class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map=new int[26];
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i=0;i<tasks.length;i++){
            char ch=tasks[i];
            map[ch-'A']++;
        }
        for(int i=0;i<26;i++){
           if(map[i]!=0){
            pq.add(map[i]);
           }
        }
        Queue<int[]> q=new LinkedList<>();
        int time=0;
        while(!q.isEmpty() || !pq.isEmpty()){
             if(!q.isEmpty() && time>q.peek()[1]){
                int[] temp=q.poll();
                pq.add(temp[0]);
             }
             if(!pq.isEmpty()){
                int interval=pq.poll();
             if(interval-1>0){
             q.offer(new int[]{interval-1,time+n});
             }
             }
             time++;
        }
        return time;
        
    }
}
