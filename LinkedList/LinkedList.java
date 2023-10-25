/*            Linked List and all it's basic Operations        */

public class LinkedList {
    // Creating our first Linked List class...!
    public static class Node {
        // entering properties...!
        int data;
        Node next;

        // Making a constructor...!
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Creating head and tail node in a linkedList...!
    public static Node head;
    public static Node tail;
    public static int size;

    // Adding a new Node at the head...!
    public void addFirst(int data) {
        // step 1. Create a new Node..!
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Step 2. point newNode's next = head..!
        newNode.next = head;

        // step 3. head = newNode..!
        head = newNode;
    }

    // Adding a new node at the tail..!
    public void addLast(int data) {
        // Step 1. Create a new Node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Step 2. point tail's next = newNode..!
        tail.next = newNode;

        // Step 3. tail = newNode..!
        tail = newNode;
    }

    // Function for printing the linked List...!
    public void print() {
        Node temp = head;
        if (head == null) {
            System.out.println("linked List is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Function for Adding in the middle of the linked list..!
    public void AddMiddle(int idx, int data) {
        Node newNode = new Node(data);
        size++;
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Function to remove a node from first...!
    public int removeFirst() {
        if (size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // Function to remove a node from Last...!
    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Function to Search any value in linkedList...!(iterative approach)
    public int iterativeSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        // if not found...!
        return -1;
    }

    // Function to Search any value in linkedList...!(recursive approach)..!
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    // (**imp) Function to Reverse a linked List (using Iterative approach)
    public void reverse() { // T.C -> O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;
        // learn these four steps :)
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Find and remove Nth node from the End...! (iterative approach) (T.C -> O(n))
    public void deleteNthNodeFromEnd(int n) {
        /*
         * // *** (N)th from End == (size - N + 1) from start...!
         * // Method to find size of a linkedList...!
         * int sz = 0;
         * Node temp = head;
         * while(temp != null) {
         * temp = temp.next;
         * sz++;
         * }
         */
        if (n == size) {
            head = head.next; // removeFirst() fnx;
            return;
        }

        int i = 1;
        Node prev = head;
        while (i < size - n) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    // Step 1 -> Finding Middle (Slow-Fast Approach)
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow;
    }

    // Function to Check if the linkedList is a Palindrome or not..!
    /*
     * There are basically three steps tpo find it..!
     * 1. Find the middle Node of the LinkedList (can be done using Slow-Fast
     * Method).
     * 2. Reverse the second Half of the linkedList (can be done using the above
     * Reverse function)
     * 3. Check if the first half is = second half.
     */

    public boolean checkPalindrome() {
        // Base Case...1
        if (head == null || head.next == null) {
            return true;
        }

        // step 1 -> find MidNode
        Node midNode = findMid(head);

        // Step 2 -> reverse the sec Half
        Node curr = midNode;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right half's head
        Node left = head;

        // Step 3 -> check left half and right half

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
    //cycle detection in linked list using hare-turtle approach
    public static boolean hasCycle(Node head) {
        if(head==null)
            return false;
        Node hare=head;
        Node turtle=head;
        while(hare!=null && hare.next!=null)
        {
            hare=hare.next.next;//hare jumps two places
            turtle=turtle.next;//turtle jumps one places
            if(hare==turtle)//at some point, the will meet each other which indicates linked list is cyclic
                return true;
        }  
    return false;//if linked list is non-cyclic      
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addLast(0);
        ll.addLast(-4);
        tail.next=head.next;// to make the linked list cyclic
        System.out.println(hasCycle(ll.head));
        ll.AddMiddle(2, 3);
        ll.AddMiddle(3, 4);
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll.iterativeSearch(3));
        System.out.println(ll.recSearch(12));
        ll.reverse();
        ll.deleteNthNodeFromEnd(2);
        System.out.println(ll.checkPalindrome());
        ll.print();
    }
}
