package LinkedListProbs;

public class DoublyListWithTail<T> {
    public class Node {
        public T data;
        public Node prev;
        public Node next;

        Node(T data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public DoublyListWithTail() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertAtStart(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (!isEmpty())
            head.prev = newNode; //if list is not empty new node becomes new head and current head will be second node//tail does not need to change here and keep pointing to where it was
        else
            tail = newNode; //if it is an empty list tail will be at new node/head
        //head and tail only get initialized here as this is the first node created
        head = newNode; //Since we added new node at start new node becomes new head
        size++;
    }

    public void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtStart(data);
            return;
        }
        tail.next = new Node(data);
        tail.next.prev = tail;
        tail = tail.next;
        size++;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("empty list");
            return;
        }

        Node temp = head;
        System.out.print("List : ");
        while (temp.next != null) {
            System.out.print(temp.data.toString() + " <-> ");
            temp = temp.next;
        }
        System.out.println(temp.data.toString() + " <-> null");
    }

    public int getSize() {
        return size;
    }

    public Node getTail() {
        return tail;
    }

    public Node getHead() {
        return head;
    }

    public boolean isEmpty() {
        if (head == null && tail == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DoublyListWithTail<Integer> doublyListWithTail = new DoublyListWithTail<>();

        //create and print a list
        for (int i = 1; i <= 10; i++) {
            doublyListWithTail.insertAtStart(i);
        }
        doublyListWithTail.insertAtEnd(11);
        doublyListWithTail.insertAtStart(11);
        doublyListWithTail.printList();

    }
}
