class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> map=new HashSet<>();
        int dupli=0;
        int i=0;
        int ans=0;
        for(int j=0;j<s.length();j++){
            char ch=s.charAt(j);
            if(!map.contains(ch)){
                map.add(ch);
                ans=Math.max(ans,j-i+1);
            }else{
                while(s.charAt(i)!=ch){
                    map.remove(s.charAt(i));
                    i++;
                }
                if(s.charAt(i)==ch){
                    i++;
                }
            }
        }
        return ans;
    }
}