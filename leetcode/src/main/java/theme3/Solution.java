package theme3;

class Solution {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     */
//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        int l = 0, r = 0;
//        int ret = 0;
//        // 快指针移动
//        while (r < n) {
//            // 循环双指针内元素，和最右侧元素比较
//            int tmp = l;
//            while (tmp < r) {
//                if (s.charAt(tmp) == s.charAt(r)) {
//                    // 如果双指针内元素存在重复的，慢指针前移，接着循环双指针内元素
//                    l = tmp + 1;
//                }
//                tmp++;
//            }
//            ret = Math.max(ret, r - l + 1);
//            r++;
//        }
//        return ret;
//    }
    public int lengthOfLongestSubstring(String s) {
        int ret = 0, length = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            for (int tmp = left; tmp < right; tmp++) {
                if (s.charAt(tmp) == s.charAt(right)) {
                    left = tmp + 1;
                    length = right - left + 1;
                    break;
                }
            }
            length++;
            ret = Math.max(ret, length);
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("au"));
    }
}