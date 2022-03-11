package LinkedList;

public class DeleteKthToLast {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createList(vals);
        ListNode.printList(head);
        ListNode res = deleteKthtoLast(head, 2);
        ListNode.printList(res);
    }

    public static ListNode deleteKthtoLast(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode front = dummy;

        for (int i = 0; i < k; i++) {
            front = front.next;
        }

        ListNode curr = dummy;
        while (front != null && front.next != null) {
            front = front.next;
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return dummy.next;
    }
}
