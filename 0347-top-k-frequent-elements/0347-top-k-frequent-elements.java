class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        List<Integer>[] freq = new ArrayList[nums.length + 1];

        for (int i = 0; i <= nums.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int val = map.get(nums[i]);
                map.put(nums[i], val + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        map.forEach((key, value) -> {
            freq[value].add(key);
        });
        int ans[] = new int[k];
        int j = 0;
        for (int i = freq.length - 1; i >= 0 && j < k; i--) {
            for (int num : freq[i]) {
                ans[j++] = num;
                if (j == k) {
                    return ans;
                }
            }
        }
        return ans;

    }
}