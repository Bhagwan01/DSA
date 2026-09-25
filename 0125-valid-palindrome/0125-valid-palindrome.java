class Solution {
    public boolean isPalindrome(String s) {
        if(s.equals(" ")){
            return true;
        }
        s=s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char st=s.charAt(i);
            char end=s.charAt(j);
            if(!Character.isLetterOrDigit(st)){
                i++;
                continue;
            }else if(!Character.isLetterOrDigit(end)){
                j--;
                continue;
            }
            if(st==end){
                i++;j--;
            }else{
                return false;
            }
        }
        return true;
    }
}