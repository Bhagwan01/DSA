class Solution {
    public long maximizeSum(int[] nums, int k) {
        long ans=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(b[2]==a[2]){
                return Integer.compare(b[0],a[0]);
            }
            return Integer.compare(b[2],a[2]);
        });
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            String s=String.valueOf(curr);
            char[] carr=s.toCharArray();
            Arrays.sort(carr);
            String s2=new String(carr);
            String sb=new StringBuilder(new String(s2)).reverse().toString();
            int temp=Integer.parseInt(sb);
            pq.offer(new int[]{temp,curr,Math.abs(temp-curr)});
        }
       
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int firs=arr[0];
            int sec=arr[1];
            int third=arr[2];
            //System.out.println(firs+" "+sec);
            if(k>0){
                ans+=firs;
            }else{
                ans+=sec;
            }
        
            if(firs!=sec){
                k--;
            }
        }
        return ans;
    }
}