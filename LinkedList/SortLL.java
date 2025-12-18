class SortLL {
    public ListNode sortList(ListNode head) {
        // PriorityQueue<Integer>queue=new PriorityQueue<>();
        // ListNode curr=head;
        // while(curr!=null){
        // queue.add(curr.val);
        // curr=curr.next;
        // }
        // ListNode dummy=new ListNode();
        // ListNode currNode=dummy;
        // while(!queue.isEmpty()){
        // currNode.next=new ListNode(queue.poll());
        // currNode=currNode.next;
        // }
        // return dummy.next;

        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;

        ListNode leftSort = sortList(head);
        ListNode rightSort = sortList(right);

        return merge(leftSort, rightSort);
    }

    public ListNode getMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode dummy = temp;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if (l1 != null) {
            dummy.next = l1;
            return temp.next;
        } else {
            dummy.next = l2;
            return temp.next;
        }
    }
}