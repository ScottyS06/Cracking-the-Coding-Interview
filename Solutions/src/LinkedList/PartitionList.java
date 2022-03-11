package LinkedList;

public class PartitionList {
    public static void main(String[] args) {
        int[] vals = {1, 4, 8, 5, 2, 6, 3, 10};
        ListNode head = ListNode.createList(vals);
        ListNode.printList(head);
        ListNode res = partitionList(head, 7);
        ListNode.printList(res);
    }

    public static ListNode partitionList(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        ListNode result = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode currRes = result;
        while (curr != null) {
            if (curr.val < x) {
                currRes.next = curr;
                currRes = currRes.next;
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        currRes.next = dummy.next;
        return result.next;
    }
}
