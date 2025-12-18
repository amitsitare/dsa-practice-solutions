class DeleteFromMiddle {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // int len=1;
        // ListNode curr=head;
        // while(curr.next!=null){
        // curr=curr.next;
        // len++;
        // }
        // ListNode node=head;
        // int n=len/2;
        // for(int i=1;i<n;i++){
        // node=node.next;
        // }
        // node.next=node.next.next;
        // return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        prev.next = slow.next;
        return head;
    }
}