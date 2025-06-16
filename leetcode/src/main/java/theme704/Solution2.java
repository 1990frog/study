package theme704;

public class Solution2 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 0));
    }
}
