package LinkedList;

public class DeleteKthToLast {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3, 4, 5};
        ListNode head = createList(vals);
        printList(head);
        ListNode res = deleteKthtoLast(head, 2);
        printList(res);
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
