package theme209;

class Solution {
//    public int minSubArrayLen(int target, int[] nums) {
//        int ret = 0;
//        // n 窗口大小
//        for (int i = 0; i < nums.length; i++) {
//            int l = 0, r = l + i;
//            // 窗口移动
//            while (r < nums.length) {
//                int val = 0;
//                for (int k = l; k <= r; k++) {
//                    val += nums[k];
//                }
//                if (val >= target) {
//                    return r - l + 1;
//                }
//                l++;
//                r++;
//            }
//        }
//        return ret;
//    }

//    public int minSubArrayLen(int target, int[] nums) {
//        int ret = nums.length + 1;
//        int sum = 0;
//        int start = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            while (sum >= target) {
//                sum -= nums[start];
//                ret = Math.min(ret, i - start + 1);
//                start++;
//            }
//        }
//        return ret == nums.length + 1 ? 0 : ret;
//    }

    public int minSubArrayLen(int target, int[] nums) {
        int ret = nums.length + 1;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                sum -= nums[start];
                ret = Math.min(ret, i - start + 1);
                start++;
            }

        }
        return ret == nums.length + 1 ? 0 : ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}