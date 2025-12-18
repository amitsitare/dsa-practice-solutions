class IsPallindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        while (prev != null) {
            if (prev.val == head.val) {
                head = head.next;
                prev = prev.next;
            } else {
                return false;
            }
        }
        return true;

    }
}