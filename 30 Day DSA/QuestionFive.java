import java.util.*;

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class QuestionFive {
    public static void main(String[] args) {
        // Test Case 1: head = [1, 2, 3, 4, 5]
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Original List 1: ");
        printList(head1);
        ListNode reversed1 = reverseList(head1);
        System.out.print("Reversed List 1: ");
        printList(reversed1);

        // Test Case 2: head = [1, 2]
        ListNode head2 = createList(new int[]{1, 2});
        System.out.print("\nOriginal List 2: ");
        printList(head2);
        ListNode reversed2 = reverseList(head2);
        System.out.print("Reversed List 2: ");
        printList(reversed2);

        // Test Case 3: head = []
        ListNode head3 = createList(new int[]{});
        System.out.print("\nOriginal List 3: ");
        printList(head3);
        ListNode reversed3 = reverseList(head3);
        System.out.print("Reversed List 3: ");
        printList(reversed3);
    }

    // Function to reverse a linked list using a stack
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;

        // Push all nodes to the stack
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        // Pop from stack to rebuild reversed list
        ListNode newHead = stack.pop();
        current = newHead;

        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }

        current.next = null;

        return newHead;

        /*
        Iteration-wise for input: [1,2,3,4,5]

        Stack after push:
        Top -> 5 -> 4 -> 3 -> 2 -> 1

        Pop and reassign:
        newHead = 5
        5.next = 4
        4.next = 3
        3.next = 2
        2.next = 1
        1.next = null

        Final list: [5, 4, 3, 2, 1]
        */
    }

    // Utility: Convert array to linked list
    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Utility: Print linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);
            current = current.next;
            if (current != null) System.out.print(", ");
        }
        System.out.println("]");
    }
}
