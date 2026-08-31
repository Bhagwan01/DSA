class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
    }
        int[] freq=new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }
        if(allZeros(freq)) return true;
        for(int i=s1.length();i<s2.length();i++){
            // move window
            freq[s2.charAt(i)-'a']--;

            freq[s2.charAt(i-s1.length())-'a']++;
            if(allZeros(freq)) return true;
        }
        return false;
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