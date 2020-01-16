import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ret = 0;
        List<Integer> list = new ArrayList();
        for (int i:nums1){
            list.add(i);
        }
        for (int i:nums2){
            list.add(i);
        }
        list.sort(Comparator.comparingInt(a -> a));
        System.out.println(list);
        if(list.size()%2==0){
            ret = (list.get(list.size()/2)+list.get(list.size()/2-1))/(double)2;
        }else{
            ret = list.get((list.size()-1)/2);
        }
        return ret;
    }

    @Test
    public void test(){
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
