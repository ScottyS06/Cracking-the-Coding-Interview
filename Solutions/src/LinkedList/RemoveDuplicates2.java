package LinkedList;
import java.util.*;

public class RemoveDuplicates2 {
    public static void main(String[] args) {
        int[] vals = {1, 1, 2, 1};
        ListNode head = ListNode.createList(vals);
        ListNode.printList(head);
        ListNode res = removeDuplicates(head);
        ListNode.printList(res);
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
}
