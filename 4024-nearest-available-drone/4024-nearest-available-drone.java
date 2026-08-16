class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int dist=(int)1e9;
        int idx=-1;
        for(int i=0;i<drones.length;i++){
            int temp_dist=Math.abs(drones[i][0]-target[0])+Math.abs(drones[i][1]-target[1]);
            if(temp_dist<=drones[i][2] && temp_dist<dist){
                dist=temp_dist;
                idx=i;
            }
        }
        return idx;

    }
}