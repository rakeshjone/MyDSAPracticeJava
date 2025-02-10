package LinkedListProbs;

public class SinglyLinkedList<T> {
    class Node {
        public T data;
        public Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public int size;

    SinglyLinkedList() {
        head = null;
        size = 0;
    }

    //Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }

    //Insert at the start of the list
    public void insertAtStart(T data) {
        Node newNode = new Node(data);
        //in case there are already some nodes present
        newNode.next = head;
        head = newNode;
        size++;
    }

    //Insert at end
    public void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtStart(data);
            return;
        }

        Node index = head;
        while (index!=null) {
            index=index.next;
        }
        index = new Node(data);
        size++;

    }

    //Insert after data
    public void insertAfter(T thisData, T afterThis) {
        Node newNode = new Node(thisData);
        Node index = head;
        while(index.next!=null) {
            if (index.data.equals(afterThis)) {
                Node temp = index.next;
                index.next = newNode;
                newNode.next = temp;
                size++;
                break;
            }
            index = index.next;
        }
    }

    //Deletes data from the head of list
    public void deleteAtHead() {
        //if list is empty then simply return
        if (isEmpty())
            return;
        //make the nextNode of the headNode equal to new headNode
        head = head.next;
        size--;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("empty list");
            return;
        }
        Node temp = head;
        System.out.print("List : ");
        while (temp.next!=null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data.toString() + "-> null");
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> ssl = new SinglyLinkedList<Integer>();

        //create and print a list
        for (int i = 1; i <= 1; i++) {
            ssl.insertAtStart(i);
        }
        ssl.printList();
/*
        //Modify and print the list by inserting in-between
        ssl.insertAfter(11,10);
        ssl.insertAtEnd(21);
        ssl.insertAtStart(22);
        ssl.printList();
        ssl.deleteAtHead();
        ssl.deleteAtHead();
        ssl.deleteAtHead();
        ssl.printList();

*/
    }
}
