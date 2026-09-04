class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
       
        int st=0;
        int[] lastOccur=new int[26];
        for(int i=0;i<s.length();i++){
            lastOccur[s.charAt(i)-'a']=i;
        }
         int maxOccur=lastOccur[s.charAt(0)-'a'];
        for(int i=1;i<s.length();i++){
            if(i>maxOccur){
                if(ans.size()==0){
                    ans.add(maxOccur-st+1);
                }else{
                    ans.add(maxOccur-st);
                }
                st=maxOccur;
            }
            maxOccur=Math.max(maxOccur,lastOccur[s.charAt(i)-'a']);
        }
        if(maxOccur==s.length()-1){
            if(ans.size()==0){
                ans.add(maxOccur-st+1);
            }else{
                ans.add(maxOccur-st);
            }
        }
        return ans;
    }
}