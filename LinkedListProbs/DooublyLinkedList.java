package LinkedListProbs;

public class DooublyLinkedList<T> {

    class Node {
        public Node previous;
        public T data;
        public Node next;

        Node(T data) {
            this.data = data;
            previous = null;
            next = null;
        }
    }

    Node head;
    int size;

    public DooublyLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtStart(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head.previous = newNode;
        head = newNode; //we have a new head now as we have added new node at the start
        size++;
    }


    public void printList() {
        if (isEmpty()) {
            System.out.println("empty list");
            return;
        }
        DooublyLinkedList.Node temp = head;
        System.out.print("List : ");
        while (temp.next!=null) {
            System.out.print(temp.data.toString() + " <-> ");
            temp = temp.next;
        }
        System.out.println(temp.data.toString() + "<-> null");
    }


}
