public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * 计算arr[l..n)这个区间内所有数字的和
     * 递归算法分为两部分：
     * 第一部分：求解最基本的问题 step1
     * 第二部分：把原问题转化为更小的问题
     *
     * @param arr
     * @param l
     * @return
     */
    private static int sum(int[] arr, int l) {
        if (l == arr.length)
            return 0; // step1
        return arr[l] + sum(arr, l + 1);
    }
}
