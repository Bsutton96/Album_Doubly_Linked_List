import org.junit.jupiter.api.Test;

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
}