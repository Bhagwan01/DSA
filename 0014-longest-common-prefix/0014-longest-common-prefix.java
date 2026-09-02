class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans="";
        if(strs.length==1){
          return strs[0];
        }
        int min=(int)1e9;
        for(int i=1;i<strs.length;i++){
           String first=strs[i];
           String sec=strs[i-1];
            int temp=0;
            int k=0;
            int j=0;
            int minLen=Math.min(first.length(),sec.length());
            while(k<minLen && j<minLen){
                if(first.charAt(k)!=sec.charAt(j)){
                    break;
                }
                temp++;
                k++;j++;
            }
            min=Math.min(min,temp);
        }
        if(min==0){
            return ans;
        }
        return strs[0].substring(0,min);
    }
}