import java.util.Objects;

public class Song {

    private final String title;
    private final String artist;
    private final String genre;

    public Song(String title, String artist, String genre) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Song title cannot be null or empty");
        }

        if (artist == null || artist.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Song artist cannot be null or empty");
        }

        this.title = title.trim();
        this.artist = artist.trim();
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Song that = (Song) other;

        return title.equalsIgnoreCase(that.title)
            && artist.equalsIgnoreCase(that.artist)
            && Objects.equals(genre, that.genre);
    }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + genre + ")";
    }
}