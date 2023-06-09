import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class AlbumTest {

    @Test
    void albumTest() {
        Album Californication = new Album(001, "Red Hot Chili Peppers", "Californication", 15);
    }

    @Test
    void toStringTest() {
        Album Californication = new Album(001, "Red Hot Chili Peppers", "Californication", 15);

        System.out.println(Californication.toString());
    }

    @Test
    void compareAlbumsTest() {
        Album Californication = new Album(001, "Red Hot Chili Peppers", "Californication", 15);
        Album stadiumArcadium = new Album(002, "Red Hot Chili Peppers", "Stadium Arcadium", 29);

        System.out.println(Californication.compareTo(stadiumArcadium));
    }

    @Test
    public void testAppend() {
        DoublyLinkedList<Integer> testList = new DoublyLinkedList<>();

        Node node1 = testList.append(1);
        Node node2 = testList.append(2);
        Node node3 = testList.append(3);

        Assertions.assertNotNull(node1);
        Assertions.assertNotNull(node2);
        Assertions.assertNotNull(node3);

        System.out.println(String.valueOf(node1));
        System.out.println(String.valueOf(node2));
        System.out.println(String.valueOf(node3));

    }

    @Test
    public void testInsert() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);

        String expected = "1 -> 2 -> 3 -> NULL";
        String actual = list.toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDeleteSingleNode() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(0, 1);
        Assertions.assertEquals(Integer.valueOf(1), list.delete(0).data);
        Assertions.assertEquals(0, list.size);
    }

    @Test
    public void testGetIndex() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        Assertions.assertEquals(0, list.getIndex(1));
        Assertions.assertEquals(2, list.getIndex(3));
        Assertions.assertEquals(4, list.getIndex(5));
        Assertions.assertEquals(-1, list.getIndex(6));
    }

    @Test
    void testToString() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Assertions.assertEquals("Invalid entry. List is empty.", list.toString());

        list.append(1);
        list.append(2);
        list.append(3);
        Assertions.assertEquals("1 -> 2 -> 3 -> NULL", list.toString());

    }

    @Test
    void testShuffle() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);
        list.insert(3, 4);
        list.insert(4, 5);
        list.insert(5, 6);
        list.shuffle();

        System.out.println(list.toString());

        Assertions.assertEquals(6, list.size);

        boolean isShuffled = false;
        Node<Integer> current = list.head;
        for (int i = 1; i <= 6; i++) {
            if (current.data != i) {
                isShuffled = true;
                break;
            }
            current = current.next;
        }
        Assertions.assertTrue(isShuffled);
    }

    @Test
    void testPartition() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.append(5);
        list.append(2);
        list.append(10);
        list.append(8);
        list.append(3);

        DoublyLinkedList<Integer> partitioned = list.partition(5);

        Assertions.assertEquals("2 -> 3 -> NULL", list.toString());
        Assertions.assertEquals("5 -> 10 -> 8 -> NULL", partitioned.toString());
    }
}
