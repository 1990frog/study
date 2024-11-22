package theme2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ret = solution.twoSum(new int[]{3,3}, 6);
        System.out.println(Arrays.toString(ret));
    }
}