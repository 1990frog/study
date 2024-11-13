package theme503;


import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    //O(n^2)
//    public int[] nextGreaterElements(int[] nums) {
//        int[] ret = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            Integer nextVal = null;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] > nums[i]) {
//                    nextVal = nums[j];
//                    break;
//                }
//            }
//            if (nextVal == null && i > 0) {
//                for (int k = 0; k < i; k++) {
//                    if (nums[k] > nums[i]) {
//                        nextVal = nums[k];
//                        break;
//                    }
//                }
//            }
//            ret[i] = nextVal == null ? -1 : nextVal;
//        }
//        return ret;
//    }

    public int[] nextGreaterElements(int[] nums) {
        int ans[] = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque();
        // stack.push(nums.length-1);
        for(int i =0;i<nums.length;i++){
            while(stack.size()>0&&nums[stack.peek()]<nums[i]){
                ans[stack.peek()]=nums[i];
                stack.pop();
            }
            // if(i!=nums.length-1)//之前放过了
            stack.push(i);
        }
        for(int i =0;i<nums.length;i++){
            while(stack.size()>0&&nums[stack.peek()]<nums[i]){
                ans[stack.peek()]=nums[i];
                stack.pop();
            }
            // if(i!=nums.length-1)//之前放过了
            // stack.push(i);
        }
        while(stack.size()>0){
            ans[stack.peek()]=-1;
            stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[]{1, 8, -1, -100, -1, 222, 1111111, -111111};
        int[] nums = new int[]{5,4,3,2,1};
        for (int next : solution.nextGreaterElements(nums)) {
            System.out.println(next);
        }
    }
}
