package LinkedList;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {}

    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createList(int[] vals) {
        ListNode head = null;
        for (int i = vals.length - 1; i >= 0; i--) {
            head = new ListNode(vals[i], head);
        }
        return head;
    }

    public static void printList(ListNode head) {
        if (head != null) {
            System.out.print(head.val);
        } else {
            System.out.println("null");
            return;
        }

        head = head.next;
        while (head != null) {
            System.out.print("->" + head.val);
            head = head.next;
        }
        System.out.println();
    }

}
