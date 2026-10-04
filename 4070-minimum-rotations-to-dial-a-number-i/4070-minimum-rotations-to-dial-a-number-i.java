class Solution {
    public int minRotations(String s) {
        int pointer=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int curr_num=ch-'0';
            int min_diff=Math.abs(pointer-curr_num);
            ans+=Math.min(min_diff,10-min_diff);
            pointer=curr_num;
        }
        return ans;
    }
}