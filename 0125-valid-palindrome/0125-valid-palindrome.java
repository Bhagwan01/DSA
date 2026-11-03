class Solution {
    public boolean isPalindrome(String s) {
        String str="";
        if(s=="" || s==" "){
            return true;
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if((ch>='0' && ch<='9')||ch>='a' && ch<='z'){
               str+=ch;
            }else if(ch>='A' && ch<='Z'){
                int next=(int)ch+32;
                char newCh=(char)(next);
                str+=newCh;

            }
        }
        int i=0;int j=str.length()-1;
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}