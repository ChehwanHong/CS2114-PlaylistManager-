
/**
 * Represents a playlist containing songs.
 *
 * @author Josiah
 * @version October 2026
 */
public class Playlist {

    private String name;
    private LinkedChain<Song> songs;

    /**
     * Creates a playlist with the given name.
     *
     * @param name the playlist name
     */
    public Playlist(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Playlist name cannot be null or empty");
        }

        this.name = name.trim();
        songs = new LinkedChain<Song>();
    }

    /**
     * Returns the playlist name.
     *
     * @return the playlist name
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a song to the playlist.
     *
     * @param song the song to add
     * @return true if the song was added
     */
    public boolean addSong(Song song) {
        if (song == null) {
            throw new IllegalArgumentException(
                "Song cannot be null");
        }

        return songs.addToEnd(song);
    }

    /**
     * Removes the first matching song from the playlist.
     *
     * @param song the song to remove
     * @return true if the song was found and removed
     */
    public boolean removeSong(Song song) {
        if (song == null) {
            return false;
        }

        return songs.remove(song);
    }

    /**
     * Checks whether the playlist contains a song.
     *
     * @param song the song to find
     * @return true if the song exists in the playlist
     */
    public boolean containsSong(Song song) {
        if (song == null) {
            return false;
        }

        return songs.contains(song);
    }

    /**
     * Returns the number of songs in the playlist.
     *
     * @return the number of songs
     */
    public int getSongCount() {
        return songs.size();
    }

    /**
     * Checks whether the playlist is empty.
     *
     * @return true if no songs are present
     */
    public boolean isEmpty() {
        return songs.isEmpty();
    }

    /**
     * Returns a readable listing of the playlist's songs.
     *
     * @return the songs in insertion order
     */
    @Override
    public String toString() {
        return name + ": " + songs.toString();
    }
}
