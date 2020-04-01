package leetcode;

import org.junit.Test;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Solution66 {

    /**
     * 巧妙。只要+1求余数，余数不等于0，说明没有进位，直接返回。如果余数等于0，说明有进位，遍历前一个数字，加1再求余数，以此循环。如果for循环都遍历完了，说明最高位也有进位，则重新建立一个数组，初始化为0，将第一位设置为1就可以了，因为，99、999之类的数字加一为100、1000
     */
    public int[] best(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne(int[] digits) {
        int step = 1;
        for (int i = digits.length; i > 0; i--) {
            int value = digits[i-1] + step;
            step = value / 10;
            digits[i-1] = value % 10;
            if (step == 0)
                step = 0;
        }
        if(step==0)
            return digits;
        else{
            int[] ret = new int[digits.length+1];
            ret[0] = step;
            for(int i=1;i<=digits.length;i++)
                ret[i]=digits[i-1];
            return ret;
        }

    }

    @Test
    public void test(){
        int[] arr = {9,2,3,4,5};
//        System.out.println(plusOne(arr));
        int[] ret = best(arr);
        for(int p:ret)
            System.out.print(p);
    }
}
