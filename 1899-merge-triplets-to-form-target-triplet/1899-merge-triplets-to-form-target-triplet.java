class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] temp = new int[3];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < triplets.length; i++) {

            if (triplets[i][0] == target[0] && triplets[i][1] == target[1] && triplets[i][2] == target[2]) {
                return true;
            }
            if (triplets[i][0] == target[0] || triplets[i][1] == target[1] || triplets[i][2] == target[2]) {
                if (!q.contains(i)) {
                    q.offer(i);
                }
            }

        }
        if (!q.isEmpty()) {
            int idx = q.poll();
            if(triplets[idx][0]<=target[0] && triplets[idx][1]<=target[1] && triplets[idx][2]<=target[2]){
            temp[0] = triplets[idx][0];
            temp[1] = triplets[idx][1];
            temp[2] = triplets[idx][2];
            }else{
                temp[0] =(int)-1e9;
            temp[1] = (int)-1e9;
            temp[2] = (int)-1e9;

            }
        }
        if (isEqual(temp, target)) {
            return true;
        }
        while (!q.isEmpty()) {
            int idx = q.poll();
            
            if(Math.max(temp[0], triplets[idx][0])>target[0] || Math.max(temp[1], triplets[idx][1])>target[1] || Math.max(temp[2], triplets[idx][2])>target[2] ){
                continue;
            }else{
                 temp[0] = Math.max(temp[0], triplets[idx][0]);
                 temp[1] = Math.max(temp[1], triplets[idx][1]);
                  temp[2] = Math.max(temp[2], triplets[idx][2]);
            }
          
            if (isEqual(temp, target)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < 3; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}