package LinkedList;
import java.util.*;

/**
 * Given the head of a linked list, find all the values that appear more than once
 * in the list and delete the nodes that have any of those values.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] vals = {1, 2, 2, 1};
        ListNode head = ListNode.createList(vals);
        ListNode.printList(head);
        ListNode res = deleteDuplicatesUnsorted(head);
        ListNode.printList(res);
    }

    public static ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> valCount = new HashMap<Integer, Integer>();

        ListNode curr = head;
        while (curr != null) {
            int value = curr.val;
            if (!valCount.containsKey(value)) {
                valCount.put(value, 0);
            }
            valCount.put(value, valCount.get(value) + 1);
            curr = curr.next;
        }

        while (head != null && valCount.get(head.val) > 1) {
            head = head.next;
        }

        curr = head;
        while (curr != null && curr.next != null) {
            if (valCount.get(curr.next.val) > 1) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }

        }
        return head;
    }
}
