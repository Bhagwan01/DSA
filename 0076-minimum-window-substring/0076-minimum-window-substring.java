class Solution {
    public String minWindow(String s, String t) {
         if(t.length()>s.length()){
            return "";
        }
        int[] freq=new int[59];
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            freq[ch-'A']++;
        }
       
        int count=t.length();
        int i=0;
        int ans=(int)1e9;
        int minidx=-1;
        int lastidx=-1;
        for(int j=0;j<s.length();j++){
            char ch=s.charAt(j);
            freq[ch-'A']--;
            if(freq[ch-'A']>=0){
                count--;
            }
            while(count==0){
                if(j-i+1<=ans){
                    ans=j-i+1;
                    minidx=i;
                    lastidx=j;
                }
                freq[s.charAt(i)-'A']++;
                if(freq[s.charAt(i)-'A']>0){
                    count++;
                }
                i++;
            }
        }
        if(minidx==-1 || lastidx==-1){
            return "";
        }

        return s.substring(minidx,lastidx+1);
    }
} 