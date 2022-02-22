/**
 *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31−1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 栈不要用for出栈
 */
public class Solution7 {

//    public int reverse(int x) {
//        try{
//            //负数标识
//            boolean negative = x<0;
//            //绝对值
//            int value = x<0?-x:x;
//            Stack stack = new Stack<>();
//            char[] chars = String.valueOf(value).toCharArray();
//            for(int i=0;i<chars.length;i++){
//                stack.push(chars[i]);
//            }
//            StringBuffer buffer = new StringBuffer();
//            while (!stack.isEmpty()){
//                buffer.append(stack.pop());
//            }
//            return negative?-Integer.parseInt(buffer.toString()):Integer.parseInt(buffer.toString());
//        }catch (NumberFormatException e){
//
//        }
//        return 0;
//    }

//    public int reverse(int x) {
//        int ans = 0;
//        while (x != 0) {
//            int pop = x % 10;
//            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
//                return 0;
//            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
//                return 0;
//            ans = ans * 10 + pop;
//            x /= 10;
//        }
//        return ans;
//    }

    public int reverse(int x) {
        int ret = 0;
        while (x != 0){
            int pop = x%10;
            ret = ret*10 + pop;
            x /= 10;
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
//        System.out.println(solution7.reverse(1534236469));
        System.out.println(solution7.reverse(123));
    }
}
