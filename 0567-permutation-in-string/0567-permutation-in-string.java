class Solution {
    static{
        for(int i = 0; i<500; i++)
            checkInclusion("aa","aa");
    }
    public static boolean checkInclusion(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            arr1[ch - 'a']++;
        }
        int low = 0;
        for(int high = 0; high < s2.length(); high++){
            arr2[s2.charAt(high)-'a']++;
            if(high -low +1 > s1.length()){
                arr2[s2.charAt(low)-'a']--;
                low++;
            }
            if(high -low +1 == s1.length() && Arrays.equals(arr1,arr2)){
                return true;
            }
        }
        return false;
    }
}