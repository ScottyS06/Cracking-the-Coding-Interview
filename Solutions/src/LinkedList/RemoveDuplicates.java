package LinkedList;
import java.util.*;

/**
 * Given the head of a linked list, find all the values that appear more than once
 * in the list and delete the nodes that have any of those values.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] vals = {1, 2, 2, 1};
        ListNode head = createList(vals);
        printList(head);
        ListNode res = deleteDuplicatesUnsorted(head);
        printList(res);
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
