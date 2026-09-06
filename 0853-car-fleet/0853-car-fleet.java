class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] car=new int[position.length][2];
        for(int i=0;i<position.length;i++){
            car[i][0]=position[i];
            car[i][1]=speed[i];
        }
        Arrays.sort(car,(a,b)->Integer.compare(a[0],b[0]));
        double maxtime=0.0;
        int fleet=0;
        for(int i=speed.length-1;i>=0;i--){
            double time=(double)(target-car[i][0])/car[i][1];
            if(time>maxtime){
                fleet++;
                maxtime=time;
            }
        }
        return fleet;

    }
}