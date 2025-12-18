public class DetectCycle {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode slow1 = head;
        while (slow1 != fast) {
            slow1 = slow1.next;
            fast = fast.next;
        }
        return slow1;

    }
}