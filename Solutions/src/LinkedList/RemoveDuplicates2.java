package LinkedList;
import java.util.*;

public class RemoveDuplicates2 {
    public static void main(String[] args) {
        int[] vals = {1, 1, 2, 1};
        ListNode head = createList(vals);
        printList(head);
        ListNode res = removeDuplicates(head);
        printList(res);
    }

    public static ListNode removeDuplicates(ListNode head) {
        Set<Integer> seen = new HashSet<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (seen.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                seen.add(curr.val);
                prev = prev.next;
            }
            curr = curr.next;
        }
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
