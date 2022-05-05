public class Solution2 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private ListNode add(ListNode l1, ListNode l2, int value) {

        int val1 = 0;
        int val2 = 0;
        ListNode l1next = null;
        ListNode l2next = null;

        if (l1 == null && l2 == null)
            if (value > 0)
                return new ListNode(value);
            else
                return null;

        if (l1 != null) {
            val1 = l1.val;
            l1next = l1.next;
        }
        if (l2 != null) {
            val2 = l2.val;
            l2next = l2.next;
        }


        int val = val1 + val2 + value;
        ListNode node = new ListNode(val % 10);
        if (val > 9) {
            node.next = add(l1next, l2next, 1);
        } else {
            node.next = add(l1next, l2next, 0);
        }
        return node;
    }

}