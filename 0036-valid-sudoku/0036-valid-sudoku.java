class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check row
        for(int i=0;i<9;i++){
            boolean[] valid=new boolean[10];
            for(int j=0;j<9;j++){
                char ch=board[i][j];
                if(ch=='.'){
                    continue;
                }
                int temp=Character.getNumericValue(ch);
                if(valid[temp]==true){
                    return false;
                }
                    valid[temp]=true;

                
            }
        }
        //check col
        for(int i=0;i<9;i++){
            boolean[] valid=new boolean[10];
            for(int j=0;j<9;j++){
                char ch=board[j][i];
                if(ch=='.'){
                    continue;
                }
                int temp=Character.getNumericValue(ch);
                if(valid[temp]==true){
                    return false;
                }
                    valid[temp]=true;

                
            }
        }
        //check 3X3
        for(int i=0;i<9;i+=3){
            boolean[] valid=new boolean[10];
            for(int j=0;j<9;j++){
                if(j%3==0){
                    Arrays.fill(valid,false);
                }
                for(int k=0;k<3;k++){
                   
                    char ch=board[i+k][j];
                    if(ch=='.'){
                        continue;
                    }
                    int temp=Character.getNumericValue(ch);
                     System.out.println(temp);
                    if(valid[temp]){
                        return false;
                    }
                    valid[temp]=true;
                }
            }
        }
        
        return true;

    }
}