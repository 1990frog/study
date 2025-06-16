import org.w3c.dom.NodeList;

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

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        return add(l1, l2, 0);
//    }
//
//    private ListNode add(ListNode l1, ListNode l2, int value) {
//
//        if (l1 == null && l2 == null)
//            if (value > 0)
//                return new ListNode(value);
//            else
//                return null;
//
//        int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + value;
//        ListNode node = new ListNode(val % 10);
//        node.next = add(l1 == null ? null : l1.next, l2 == null ? null : l2.next, val / 10);
//        return node;
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Cur = l1;
        ListNode l2Cur = l2;
        while (l1Cur!=null || l2Cur!=null){

        }
        return l1;
    }

    private void addLevel(ListNode ln){

    }

}