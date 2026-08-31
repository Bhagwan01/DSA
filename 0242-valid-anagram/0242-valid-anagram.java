class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alpha=new int[26];
        if (s.length() != t.length()) {
            return false;
        }

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int idx=ch-('a');
            alpha[idx]+=1;
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            int idx=ch-'a';
            if(alpha[idx]==0){
                return false;
            }else{
                alpha[idx]=alpha[idx]-1;
            }
        }
        for(int i=0;i<26;i++){
            if(alpha[i]!=0){
                return false;
            }
        }
        return true;
    }
}