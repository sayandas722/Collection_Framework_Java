import java.util.Collections;
import java.util.List;

//  Some other important questions on linkedList...!

public class LinkedList_II {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Function to add Node in a linkedList...!
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Function to print the linkedList..!
    public void print() {
        if (head == null) {
            System.out.println("LinkedList is Empty...!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Function to detect a loop/ cycle in a LinkedList..!
    public boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // Cycle exist
                return true;
            }
        }
        return false; // cycle doesn't exist
    }

    // Function to remove the cycle in a LinkedList
    /**
     * It follows three steps...!
     * 1. Detect cycle
     * 2. Find Meeting Point
     * 3. Remove Cycle (Last.next = null);
     */
    public void removeCycle() {
        // detect cycle..!
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        // Finding Meeting Point...!
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Remove Cycle...!
        prev.next = null;
    }

    /**
     * Function for Merge Sort in a Linked List can be made in three steps..!
     * 1. find the middle of linked List
     * 2. divide the linked list into two halves(left and right)( can be by made by
     * doing mid.next = null)
     * Apply merge Sort on both halves(left and right)
     * 3. Merge both halves after Sorting them separately.
     */

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next; // Modified Slow-Fast Approach

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Mid
    }

    private Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) { // adding the smaller value
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        // Adding the rest value of right and left linkedList
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public Node MergeSort(Node head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find Mid
        Node mid = getMid(head);

        // left and right MergeSort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = MergeSort(head); // sorting left part
        Node newRight = MergeSort(rightHead); // sorting right part

        // Merge
        return merge(newLeft, newRight);

    }

    /**
     * Zig-Zag Linked List: (a medium level imp Question)
     * for a LinkedList of form : 1 -> 2 -> 3 -> 4 -> 5 -> 6, convert it
     * mid => 3, mid.next => null => leftll = 1 - 2 - 3 - null
     * rightll = 4 - 5 - 6 - null
     * reverse(rightll) = 6 - 5 - 4 and leftll = 1 - 2 - 3 - null
     * Answer => left1 -> right1 -> left2 -> right2 -> ....
     * Answer => 1 -> 6 -> 2 -> 5 -> 3 -> 4
     */
    public Node ZigZagLL(Node head) {
        // Find Middle node
        Node mid = getMid(head);
        Node curr = mid.next;
        mid.next = null;

        // Reverse the right Node
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Prev = head of right Half in reverse order...!
        Node rightHead = prev;
        Node leftHead = head;

        while (leftHead != null && rightHead != null) {
            // Adding in a zigZag fashion..!
            Node nextleft = leftHead.next;
            leftHead.next = rightHead;
            Node nextright = rightHead.next;
            rightHead.next = nextleft;

            // updating left and right head;
            rightHead = nextright;
            leftHead = nextleft;

        }
        return head;

    }

    public static void main(String[] args) {
        LinkedList_II ll = new LinkedList_II();
        // ll.addFirst(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // ll.addFirst(3);
        // head.next.next.next = temp;
        // System.out.println(ll.isCycle());
        // ll.removeCycle();
        // System.out.println(ll.isCycle());
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();
        // ll.head = ll.MergeSort(head);
        ll.head = ll.ZigZagLL(head);
        ll.print();

    }
}
