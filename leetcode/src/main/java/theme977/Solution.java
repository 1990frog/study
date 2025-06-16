package theme977;

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int length = nums.length-1;
        int[] ans = new int[nums.length];
        while (l<=r){
            if(Math.pow(nums[l],2)<Math.pow(nums[r],2)){
                ans[length] = (int) Math.pow(nums[r],2);
                r--;
            }else{
                ans[length] = (int) Math.pow(nums[l],2);
                l++;
            }
            length--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = solution.sortedSquares(new int[]{-4,-1,0,3,10});
        System.out.println(Arrays.toString(ans));
    }
}