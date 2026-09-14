class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] temp=new int[3];
        for(int i=0;i<triplets.length;i++){
            if(triplets[i][0]>target[0] || triplets[i][1]>target[1] || triplets[i][2]>target[2]){
                continue;
            }
            temp[0]=Math.max(temp[0],triplets[i][0]);
             temp[1]=Math.max(temp[1],triplets[i][1]);
              temp[2]=Math.max(temp[2],triplets[i][2]);
        }
        if(temp[0]==target[0] && temp[1]==target[1] && temp[2]==target[2]){
            return true;
        }
        return false;
    }
}