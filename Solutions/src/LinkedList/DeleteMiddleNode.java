package LinkedList;

/**
 * You are given the head of a linked list. Delete the middle node,
 * and return the head of the modified linked list.
 *
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node
 * from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
 */
public class DeleteMiddleNode {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createList(vals);
        ListNode.printList(head);
        ListNode res = deleteMiddleNode(head);
        ListNode.printList(res);
    }

    public static ListNode deleteMiddleNode(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
