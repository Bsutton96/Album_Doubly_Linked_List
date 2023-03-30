public class Node<T extends Comparable<T>> {

    private T data;

    Node prev;

    Node next;

    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

}

