package theme27;

import java.util.Arrays;

public class Solution {
    // O(n^2)
//    public int removeElement(int[] nums, int val) {
//        int length = nums.length;
//        for(int i = 0; i < length; i++){
//            if(nums[i] == val){
//                for(int j=i;j<nums.length-1;j++){
//                    if(j == length - 1){
//                        nums[j] = nums[0];
//                    }else{
//                        nums[j] = nums[j+1];
//                    }
//                }
//                i--;
//                length--;
//            }
//        }
//        return length;
//    }

//    public int removeElement(int[] nums, int val) {
//        if(nums.length==0){
//            return 0;
//        }
//        int l=0,r=nums.length-1;
//        while (l<=r){
//            if(nums[r] == val){
//                r--;
//            }else if(nums[l] == val){
//                nums[l] = nums[r];
//                nums[r] = val;
//                l++;
//            } else if (nums[l]!=val) {
//                l++;
//            }
//        }
//        return l+1;
//    }

    public int removeElement(int[] nums, int val){
        int n = nums.length;
        int l = 0;
        for (int r=0;r<n;r++){
            if(nums[r] != val){
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {3,2,2,3};
//        int[] nums = {0,1,2,2,3,0,4,2};
//        int target = 2;
        int[] nums = {1,2,2,4,5,6,7};
        int target = 2;
        System.out.println(solution.removeElement(nums, target));
        System.out.println(Arrays.toString(nums));
    }
}
