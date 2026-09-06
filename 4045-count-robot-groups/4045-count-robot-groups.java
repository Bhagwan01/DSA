class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int fleet=0;
        int pos=0;
        int maxspeed=(int)1e9;
        for(int i=speed.length-1;i>=0;i--){
            if(i!=speed.length-1 && pos-position[i]<=distance){
                 pos=position[i];
                continue;
            }
             if(speed[i]<=maxspeed){
                fleet++;
                maxspeed=speed[i];
               
            } 
             pos=position[i];
           // System.out.println(fleet +" "+i+" "+pos);
        }
        return fleet;
    }
}