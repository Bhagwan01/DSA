class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        int maxOccur=s.lastIndexOf(s.charAt(0));
        int st=0;
        for(int i=1;i<s.length();i++){
            if(i>maxOccur){
                if(ans.size()==0){
                    ans.add(maxOccur-st+1);
                }else{
                    ans.add(maxOccur-st);
                }
                st=maxOccur;
            }
            maxOccur=Math.max(maxOccur,s.lastIndexOf(s.charAt(i)));
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