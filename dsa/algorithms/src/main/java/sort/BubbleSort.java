package sort;
/**
 * 它是一种较简单的排序算法。它会遍历若干次要排序的数列，每次遍历时，它都会从前往后依次的比较相邻两个数的大小；
 * 如果前者比后者大，则交换它们的位置。
 * 
 * 这样，一次遍历之后，最大的元素就在数列的末尾！ 
 * 
 * 采用相同的方法再次遍历时，第二大的元素就被排列在最大元素之前。
 * 
 * 重复此操作，直到整个数列都有序为止
 */
public class BubbleSort {

    public static void sort(int[] array) {
        boolean swapped;
        int n = array.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    // Swap the elements
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--; // Reduce the range of comparison
        } while (swapped);
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        sort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

}
