class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
        return "";
        }
        int[] freq=new int[58];
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)-'A']++;
        }
        int matched=0;
        int minSize=(int)1e9;
        int minIdx=-1;
        int j=0;
        for(int i=0;i<t.length();i++){
            if(freq[s.charAt(i)-'A']>0){
                matched++;
            }
            freq[s.charAt(i)-'A']--;
        }
        if(matched==t.length()){
            return s.substring(0,t.length());
        }
        for(int i=t.length();i<s.length();i++){
            if(freq[s.charAt(i)-'A']>0){
                matched++;
            }
            freq[s.charAt(i)-'A']--;
            while(matched==t.length()){
                if(minSize>i-j+1){
                    minSize=i-j+1;
                    minIdx=j;
                }
                freq[s.charAt(j)-'A']++;
                if(freq[s.charAt(j)-'A']>0){
                    matched--;
                }
                j++;
            }
        }
        if(minSize==(int)1e9){
            return "";
        }
        return s.substring(minIdx,minIdx+minSize);
    }
}