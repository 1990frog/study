import java.util.HashMap;
import java.util.Map;

class Solution1 {

    /**
     * time 126 ms
     * memory 41.4 MB
     */
    public int[] twoSum1(int[] nums, int target) {

        // 取反
        int[] _nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            _nums[i] = target - nums[i];

        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums.length; j++)
                if (i != j && _nums[i] == nums[j])
                    return new int[]{i, j};

        return null;
    }

    /**
     * time 21 ms
     * memory 36.2 MB
     * 复杂度 O(n^2)
     * 暴力比对
     */
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * time 2 ms
     * memory 41.1 MB
     * Hash
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}