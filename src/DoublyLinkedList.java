public class DoublyLinkedList<T extends Comparable<T>> {

    Node<T> head = null;
    Node<T> tail = null;
    int size = 0;

    public DoublyLinkedList() {

    }

    public Node append(T data) {
        Node<T> toAppend = new Node<>(data);

        if (head == null) {
            head = toAppend;
            tail = toAppend;
        } else {
            tail.next = toAppend;
            toAppend.prev = tail;
            tail = toAppend;
        }
        return toAppend;
    }

    //getNode is used for retrieval of specified position
    private Node getNode(int location) {
        if (location < 0 || location >= size) {
            throw new IllegalArgumentException("Location is out of bounds");
        }

        Node current = head;
        for (int i = 0; i < location; i++) {
            current = current.next;
        }

        return current;
    }

    //Used to insert into the list
    public Node insert(int location, T data) {
        if (location < 0 || location > size) {
            throw new IllegalArgumentException("Location is out of bounds");
        }

        Node<T> toInsert = new Node<>(data);
        if (location == 0) {
            //Insert Node at head
            toInsert.next = head;
            head.prev = toInsert;
            head = toInsert;
        } else if (location == size) {
            //Insert Node at tail
            tail.next = toInsert;
            toInsert.prev = tail;
            tail = toInsert;
        } else {
            //Insert Node into middle
            Node current = getNode(location);
            current.prev.next = toInsert;
            toInsert.prev = current.prev;
            current.prev = toInsert;
            toInsert.next = current;
        }

        size++;
        return toInsert;
    }


}
