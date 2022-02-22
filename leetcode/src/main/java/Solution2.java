/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Error1：使用基础数据类型，超过最大值报错
     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        long sum = parse(l1) + parse(l2);
//        char[] chars = String.valueOf(sum).toCharArray();
//        ListNode node = null;
//        for(int i=chars.length-1;i>=0;i--){
//            if(node==null){
//                node = new ListNode(Integer.parseInt(String.valueOf(chars[i])));
//            }else {
//                ListNode cur = node;
//                while (cur.next!=null){
//                    cur = cur.next;
//                }
//                cur.next = new ListNode(Integer.parseInt(String.valueOf(chars[i])));
//            }
//        }
//        return node;
//    }
//
//    public static long parse(ListNode list) {
//        ListNode cur = list;
//        int factor = 0;
//        long num = 0;
//        while (cur != null) {
//            long var = cur.val;
//            cur = cur.next;
//            for (int i = 0; i < factor; i++) {
//                var = var * 10;
//            }
//            factor++;
//            num += var;
//        }
//        return num;
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        int max = len1 > len2 ? len1 : len2;
        ListNode ret = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int add = 0;
        for (int i = 0; i < max; i++) {// l1 !=null || l2 != null
            int var = (cur1 == null ? 0 : cur1.val) + (cur2 == null ? 0 : cur2.val) + add;
            add = var / 10;
            var = var % 10;
            if (ret == null) {
                ret = new ListNode(var);
            } else {
                addLast(ret, var);
            }
            if (cur1 != null)
                cur1 = cur1.next;
            if (cur2 != null)
                cur2 = cur2.next;
        }
        if(add>0){
            addLast(ret,add);
        }
        return ret;
    }

    public void addLast(ListNode base, int var) {
        ListNode cur = base;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(var);
    }

    public int getLength(ListNode node) {
        int i = 0;
        ListNode cur = node;
        while (cur != null) {
            cur = cur.next;
            i++;
        }
        return i;
    }

    /**
     * Best Solution
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
    }
}
