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

    public Node delete(int location) {
        if (head == null) {
            throw new IllegalArgumentException("The list is empty");
        }
        Node current = head;
        if (location == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            return current;
        }
        for (int i = 0; i < location; i++) {
            if (current.next == null) {
                throw new IllegalArgumentException("This location does not exist.");
            }
            current = current.next;
        }
        Node deletedNode = current;
        current.prev.next = current.next;
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        size--;
        return deletedNode;
    }

    public int getIndex(T data) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public String toString() {
        if (head == null) {
            return "Invalid entry. List is empty.";
        }

        StringBuilder sb = new StringBuilder();
        Node current = head;

        while (current != null) {
            sb.append(current.data);

            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append(" -> NULL");
        return sb.toString();
    }

    public Node shuffle() {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = slow.next;
        slow.next = null;

        Node prev = null;
        Node current = secondHalf;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }
        secondHalf = prev;

        Node p1 = head;
        Node p2 = secondHalf;

        while (p1 != null && p2 != null) {
            Node next1 = p1.next;
            Node next2 = p2.next;

            p1.next = p2;
            p2.prev = p1;
            p2.next = next1;

            if (next1 != null) {
                next1.prev = p2;
            }
            p1 = next1;
            p2 = next2;
        }
        return head;
    }

    public DoublyLinkedList partition(int data) {
        DoublyLinkedList newList = new DoublyLinkedList();
        Node current = head;

        while (current != null) {
            if (current.data.compareTo(data) >= 0) {
                newList.append(current.data);

                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
            }
            current = current.next;
        }
        return newList;
    }
}
