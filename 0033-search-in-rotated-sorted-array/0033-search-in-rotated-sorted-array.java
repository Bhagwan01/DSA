class Solution {
    public int search(int[] nums, int target) {
        int max_idx = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                max_idx = i;
                break;
            }
        }
        if (max_idx == 0 && nums.length>1 && nums[max_idx]<nums[max_idx+1]) {
            max_idx = nums.length - 1;
        }

        int first_half = -1;
        int first_st = 0;
        int first_ed = max_idx;
        while (first_st <= first_ed) {
            int mid = (first_ed + first_st) / 2;
            if (first_st == first_ed && nums[mid] != target) {
                break;
            }
            if (nums[mid] == target) {
                first_half = mid;
                break;
            } else if (nums[mid] > target) {
                first_ed = mid;
            } else{
                first_st = mid + 1;
            }
            
        }
        
        int sec_half = -1;
        int sec_st = max_idx + 1;
        int sec_ed = nums.length - 1;
        if (sec_st < nums.length) {
            while (sec_st <= sec_ed) {
                int mid = (sec_ed + sec_st) / 2;
                if (sec_st == sec_ed && nums[mid] != target) {
                    break;
                }
                if (nums[mid] == target) {
                    sec_half = mid;
                    break;
                } else if (nums[mid] > target) {
                    sec_ed = mid;
                } else {
                    sec_st = mid + 1;
                }
                

            }
        }
        if (sec_half == first_half) {
            return -1;
        } else if (sec_half == -1) {
            return first_half;
        }
        return sec_half;
    }
}