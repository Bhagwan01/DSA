class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        if(p.length()>s.length()) return ans;

        int[] freq=new int[26];
        for(int i=0;i<p.length();i++){
            freq[p.charAt(i)-'a']++;
            freq[s.charAt(i)-'a']--;
        }
        if(allZeros(freq)){
            ans.add(0);
        }
        for(int i=p.length();i<s.length();i++){
            freq[s.charAt(i)-'a']--;
            freq[s.charAt(i-p.length())-'a']++;
            if(allZeros(freq)){
                ans.add(i-p.length()+1);
            }
        }
        return ans;
    }
    public boolean allZeros(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}