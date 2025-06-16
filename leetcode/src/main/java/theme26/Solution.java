package theme26;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
//    public int removeDuplicates(int[] nums) {
//        int slow = 0;
//        Set<Integer> set = new HashSet<>();
//        for (int fast = 0; fast < nums.length; fast++) {
//            if (!set.contains(nums[fast])) {
//                nums[slow] = nums[fast];
//                slow++;
//            }
//            set.add(nums[fast]);
//        }
//        return slow;
//    }

//    public int removeDuplicates(int[] nums) {
//        int f = 1, s = 0;
//        while (f < nums.length) {
//            if (nums[f] != nums[s]) {
//                nums[++s] = nums[f];
//            }
//            f++;
//        }
//        return s+1;
//    }

//    public int removeDuplicates(int[] nums) {
//        int slow = 0;
//        int fast = 0;
//        int len = nums.length;
//        while (fast < len) {
//            if(nums[fast] != nums[slow]) {
//                nums[++slow] = nums[fast];
//            }
//            fast++;
//        }
//        return slow + 1;
//    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        while (fast < n) {
            if(nums[fast] == nums[slow]) {
                fast++;
            }else{
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}