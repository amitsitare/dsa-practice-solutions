public class InterSection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;

        }
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        while (curr1 != curr2) {
            curr1 = (curr1 != null) ? curr1 = curr1.next : headB;
            curr2 = (curr2 != null) ? curr2 = curr2.next : headA;

        }
        return curr1;

    }
}