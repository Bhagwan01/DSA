class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] time=new double[position.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<position.length;i++){
            map.put(position[i],speed[i]);
        }
        Arrays.sort(position);
        for(int i=0;i<speed.length;i++){
            speed[i]=map.get(position[i]);
            int dist=target-position[i];
            time[i]=(double)dist/speed[i];
        }
        int fleet=1;
        double maxtime=time[position.length-1];
        for(int i=position.length-2;i>=0;i--){
            //System.out.println(time[i]);
            if(time[i]>maxtime){
                fleet++;
                maxtime=time[i];
            }
        }
        return fleet;
    
    }
}