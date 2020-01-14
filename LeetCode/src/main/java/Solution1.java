/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int secend = nums[j];
                if (first + secend == target) {
                    int[] ret = {i, j};
                    return ret;
                }
            }
        }

//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    return new int[] { i, j };
//                }
//            }
//        }

//        for(int i=0;i<nums.length-1;i=i+2){
//            if(nums[i]+nums[i+1]==target){
//                return new int[]{i,i+1};
//            }
//        }

        return null;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
        int[] nums = {3, 2, 4};
        int target = 6;
        for (int i : twoSum(nums, target)) {
            System.out.println(i);
        }
    }
}
