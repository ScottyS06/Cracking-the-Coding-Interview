package LinkedList;

public class PartitionList {
    public static void main(String[] args) {
        int[] vals = {1, 4, 8, 5, 2, 6, 3, 10};
        ListNode head = createList(vals);
        printList(head);
        ListNode res = partitionList(head, 7);
        printList(res);
    }

    // 1-

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
