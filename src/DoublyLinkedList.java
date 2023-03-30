public class DoublyLinkedList<T extends Comparable<T>> {

    Node<T> head = null;
    Node<T> tail = null;
    int size = 0;

    public DoublyLinkedList(){

    }

    public Node append(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }

        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        return newNode;
    }
}
