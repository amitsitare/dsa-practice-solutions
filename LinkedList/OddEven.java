class OddEven {
    public ListNode oddEvenList(ListNode head) {
        ListNode d1 = new ListNode();
        ListNode d2 = new ListNode();
        ListNode n1 = d1;
        ListNode n2 = d2;
        int count = 0;
        while (head != null) {
            if (count % 2 == 0) {
                n1.next = new ListNode(head.val);
                head = head.next;
                n1 = n1.next;
                count++;
            } else {
                n2.next = new ListNode(head.val);
                head = head.next;
                n2 = n2.next;
                count++;

            }

        }
        n1.next = d2.next;
        return d1.next;

    }
}