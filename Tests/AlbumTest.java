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

        //append testList, add 3 nodes
        Node node1 = testList.append(1);
        Node node2 = testList.append(2);
        Node node3 = testList.append(3);

        //Verify nodes are not null
        Assertions.assertNotNull(node1);
        Assertions.assertNotNull(node2);
        Assertions.assertNotNull(node3);

        //Print to verify value of nodes
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
}