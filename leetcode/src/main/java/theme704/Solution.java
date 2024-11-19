package theme704;

import lombok.extern.java.Log;

@Log
public class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        if (r == l) {
            if (nums[l] == target)
                return l;
            return -1;
        }

        int m = (l + r) / 2;
        if (nums[m] < target) {
            return binarySearch(nums, m + 1, r, target);
        } else if (nums[m] > target) {
            return binarySearch(nums, l, Math.max(m - 1, 0), target);
        } else {
            return m;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
//        System.out.println(solution.search(new int[]{-1,0,3,5,9,12}, 9));
//        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(solution.search(new int[]{2, 5}, 0));
    }
}
