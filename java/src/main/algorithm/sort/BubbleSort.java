package algorithm.sort;


public class BubbleSort {

    /**
     * 冒泡排序
     *
     * 冒泡排序的基本思想是：
     * 设排序序列的记录个数为n，进行n-1次遍历，每次遍历从开始位置依次往后，比较前后相邻元素，这样较大的元素往后移，n-1次遍历结束后，序列有序。
     *
     * 例如，对序列(3,2,1,5)进行排序的过程是：
     * 共进行3次遍历
     * 第1次遍历时先比较3和2，交换，继续比较3和1,交换，再比较3和5，不交换，这样第1次遍历结束，最大值5在最后的位置，得到序列(2,1,3,5)。
     * 第2次遍历时先比较2和1，交换，继续比较2和3，不交换，第2次遍历结束时次大值3在倒数第2的位置，得到序列(1,2,3,5)，
     * 第3次遍历时，先比较1和2，不交换，得到最终有序序列(1,2,3,5)。
     *
     * 需要注意的是，如果在某次遍历中没有发生交换，那么就不必进行下次遍历，因为序列已经有序。
     *
     *
     */
    private static void bubbleSort(int[] array) {
        boolean flag = true;

        for (int i = 0; i < array.length - 1 && flag; i++) {

            flag = false;

            for (int j = 0; j < array.length - 1 - i; j++) {

                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    flag = true;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 8, 5, 7, 4, 3};
        bubbleSort(arr);
        System.out.println(arr);
    }


}
