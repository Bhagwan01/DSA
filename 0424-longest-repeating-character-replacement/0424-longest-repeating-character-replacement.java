class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int ans=0;
        int maxfreq=0;
        int j=0;
        for(int i=0;i<s.length();i++){
         int idx=s.charAt(i)-'A';
         freq[idx]++;
         maxfreq=Math.max(maxfreq,freq[idx]);
           if((i-j+1)-maxfreq>k){
            freq[s.charAt(j)-'A']--;
            j++;
           }
           ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
    
}