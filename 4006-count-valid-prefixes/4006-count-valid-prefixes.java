class Solution {
    public int countValidPrefixes(String s) {
        int ans=1;
        int i=0;
        int j=1;
        int cz=0;
        int co=0;
        if(s.length()==1){
            return ans;
        }
        if(s.charAt(0)=='0'){
            cz++;
        }else{
            co++;
        }
        
        while(j<s.length()){
         if(s.charAt(j)=='1'){
            co++;
        }else{
            cz++;
        }
        if(j%2!=0){
            if(cz==co){
                ans++;
            }
        }else{
            if(Math.abs(cz-co)==1){
                ans++;
            }
        }
        j++;
        }
        return ans;
    }
}