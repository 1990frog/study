package theme496;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] ret = new Solution().nextGreaterElement(nums1, nums2);
        for (int j : ret) {
            System.out.println(j);
        }
    }

    // O(m+n)
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        List<Integer> list = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        int[] ret = new int[nums1.length];
//        Arrays.fill(ret, -1);
//        for (int i = 0; i < nums1.length; i++) {
//            map.put(nums1[i], i);
//        }
//        for (int i = nums2.length - 1; i >= 0; i--) {
//            int v2 = nums2[i];
//            if (map.containsKey(v2)) {
//                for (int nextElement : list) {
//                    if (nextElement > v2) {
//                        ret[map.get(v2)] = nextElement;
//                    }
//                }
//            }
//            list.add(v2);
//        }
//        return ret;
//    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<> ();
        Stack<Integer> stack = new Stack<> ();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() <= num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        // 返回容器
//        int[] res = new int[nums1.length];
//        // 单调栈
//        Deque<Integer> stack = new ArrayDeque<>();
//        for (int i = 0; i < nums1.length; i++) {
//            int num = nums1[i];
//            // nums2中当前元素位置
//            int idj = -1;
//
//            for (int j = 0; j < nums2.length; j++) {
//                if (nums2[j] == num) {
//                    // nums2中当前元素位置，从这个位置开始向后找最大元素
//                    idj = j;
//                }
//            }
//            if (!stack.isEmpty()) {
//                stack.clear();
//            }
//            for (int j = nums2.length - 1; j >= idj; j--) {
////            for (int j = idj; j <= nums2.length - 1; j++) {
//                while (!stack.isEmpty() && stack.peek() < nums2[j]) {
//                    stack.pop();
//                }
//                if (j == idj && stack.isEmpty()) {
//                    res[i] = -1;
//                }
//                if (j == idj && !stack.isEmpty()) {
//                    res[i] = stack.pop();
//                }
//                stack.push(nums2[j]);
//            }
//        }
//        return res;
//    }

//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int[] ret = new int[nums1.length];
//        Arrays.fill(ret, -1);
//        for (int i = 0; i < nums1.length; i++) {
//            map.put(nums1[i], i);
//        }
//        for (int i = nums2.length - 1; i >= 0; i--) {
//            int v = nums2[i];
//            if (map.containsKey(v)) {
//                for (int j = i + 1; j < nums2.length; j++) {
//                    if (nums2[j] > v) {
//                        ret[map.get(v)] = nums2[j];
//                        break;
//                    }
//                }
//            }
//        }
//        return ret;
//    }


//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int[] ret = new int[nums1.length];
//        for (int i = 0; i < nums1.length; i++) {
//            Stack<Integer> stack = new Stack<>();
//            for (int k : nums2) {
//                stack.push(k);
//            }
//            int v1 = nums1[i];
//            Integer ngv = null;
//            while (!stack.isEmpty()) {
//                int v2 = stack.pop();
//                if (v2 == v1) {
//                    if (ngv == null) {
//                        ret[i] = -1;
//                    } else {
//                        ret[i] = ngv;
//                    }
//                    break;
//                }
//                if (v2 > v1) {
//                    ngv = v2;
//                }
//            }
//        }
//        return ret;
//    }

    // O(n^2)
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> idx = new HashMap<>(n); // 预分配空间
        for (int i = 0; i < n; i++) {
            idx.put(nums1[i], i);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int x = nums2[i];
            while (!st.isEmpty() && x >= st.peek()) {
                // 由于 x 的出现，栈顶元素永远不会是左边元素的「下一个更大元素」
                st.pop();
            }
            if (!st.isEmpty() && idx.containsKey(x)) { // x 在 nums1 中
                ans[idx.get(x)] = st.peek(); // 记录答案
            }
            st.push(x);
        }
        return ans;
    }

}
