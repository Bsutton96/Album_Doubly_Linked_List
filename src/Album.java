public class Album implements Comparable<Album> {

    private int id;
    private String artist;
    private String title;
    private int numSongs;

    //Creating album, assigning id, artist, tile, number of songs
    public Album(int id, String artist, String title, int numSongs) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.numSongs = numSongs;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getArtist() {
        return artist;
    }
    public String getTitle() {
        return title;
    }
    public int getNumSongs() {
        return numSongs;
    }

    //Setters
    public void setId(int id){
        this.id = id;
    }
    public void setArtist(String artist){
        this.artist = artist;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setNumSongs(int numSongs){
        this.numSongs = numSongs;
    }

    //toString method properly formats album details
    @Override
    public String toString() {
        return String.format(id + ": " + numSongs + " -- " + artist);
    }

    //Comparator. Compares numSongs on two albums

    public int compareTo(Album secondAlbum) {
        return Integer.compare(this.numSongs, secondAlbum.numSongs);
    }
}

