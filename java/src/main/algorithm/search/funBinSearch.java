package algorithm.search;

public class funBinSearch {

    /**
     * 二分搜索：前提有序
     *
     * 二分查找又称折半查找，对于有序表来说，它的优点是比较次数少，查找速度快，平均性能好。
     *
     * 二分查找的基本思想是将n个元素分成大致相等的两部分，取a[n/2]与x做比较，如果x=a[n/2],则找到x，算法中止；如果x<a[n/2]，则只要在数组a的左半部分继续搜索x，如果x>a[n/2]，则只要在数组a的右半部搜索x。
     *
     * 二分查找的时间复杂度为O(logn)
     *
     */
    static int search(int[] array, int data) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (data == array[mid]) {
                return mid;
            } else if (data < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


}
