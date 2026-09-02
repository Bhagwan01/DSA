class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        if (t.length() > s.length()) {
            return ans;
        }
        int[] freq = new int[58];
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'A']++;
            freq[s.charAt(i) - 'A']--;
        }
        int minSize = (int) 1e9;
        if (allZero(freq, t)) {
           return s.substring(0, t.length());
        }

        int j = 0;
        int minIdx = 0;
        for (int i = t.length(); i < s.length(); i++) {
            freq[s.charAt(i) - 'A']--;
            while (allZero(freq, t)) {
                if (minSize > i - j + 1) {
                    minSize = i - j + 1;
                    minIdx = j;
                }
                freq[s.charAt(j) - 'A']++;
                j++;

            }
        }

        if (minSize == (int) 1e9) {
            return "";
        }
        return s.substring(minIdx, minIdx + minSize);

    }

    public boolean allZero(int[] arr, String t) {
        for (int i = 0; i < t.length(); i++) {
            if (arr[t.charAt(i) - 'A'] > 0) {
                return false;
            }
        }
        return true;
    }
}