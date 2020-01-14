import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Solution15 {
    public static List<List<Integer>> threeSum(int[] nums) {

        /**
         * o(n^3)
         */
        List ret = new ArrayList();
        for(int i=0;i<nums.length;i++)
            for(int j=i+1;j<nums.length;j++)
                for(int l=j+1;l<nums.length;l++)
                    if(nums[i]+nums[j]+nums[l]==0)
                        ret.add(new int[]{nums[i],nums[j],nums[l]});
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List list = threeSum(nums);
        System.out.println(list);
    }
}
