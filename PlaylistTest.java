
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlaylistTest
{

    @Test
    void constructorValid()
    {
        Playlist playlist = new Playlist("Favorites");

        assertEquals("Favorites", playlist.getName());
        assertTrue(playlist.isEmpty());
        assertEquals(0, playlist.getSongCount());
    }


    @Test
    void constructorInvalidName()
    {
        assertThrows(IllegalArgumentException.class, () -> new Playlist(" "));
    }


    @Test
    void addSongValid()
    {
        Playlist playlist = new Playlist("Favorites");
        Song song = new Song("Mirrors", "Justin Timberlake", "Pop");

        assertTrue(playlist.addSong(song));
        assertTrue(playlist.containsSong(song));
        assertEquals(1, playlist.getSongCount());
    }


    @Test
    void addSongNull()
    {
        Playlist playlist = new Playlist("Favorites");

        assertThrows(
            IllegalArgumentException.class,
            () -> playlist.addSong(null));

        assertTrue(playlist.isEmpty());
    }


    @Test
    void removeSongExisting()
    {
        Playlist playlist = new Playlist("Favorites");
        Song song = new Song("Mirrors", "Justin Timberlake", "Pop");
        playlist.addSong(song);

        assertTrue(playlist.removeSong(song));
        assertTrue(playlist.isEmpty());
    }


    @Test
    void removeSongNotFound()
    {
        Playlist playlist = new Playlist("Favorites");
        Song song = new Song("Mirrors", "Justin Timberlake", "Pop");

        assertFalse(playlist.removeSong(song));
        assertTrue(playlist.isEmpty());
    }


    @Test
    void removeSongFromEmptyPlaylist()
    {
        Playlist playlist = new Playlist("Favorites");

        assertFalse(
            playlist
                .removeSong(new Song("Mirrors", "Justin Timberlake", "Pop")));

        assertTrue(playlist.isEmpty());
    }


    @Test
    void containsSongNull()
    {
        Playlist playlist = new Playlist("Favorites");

        assertFalse(playlist.containsSong(null));
    }


    @Test
    void songCountAfterMultipleAdds()
    {
        Playlist playlist = new Playlist("Favorites");
        playlist.addSong(new Song("A", "Artist A", "Pop"));
        playlist.addSong(new Song("B", "Artist B", "Rock"));

        assertEquals(2, playlist.getSongCount());
    }


    @Test
    void toStringIncludesPlaylistAndSong()
    {
        Playlist playlist = new Playlist("Favorites");
        playlist.addSong(new Song("Mirrors", "Justin Timberlake", "Pop"));

        assertTrue(playlist.toString().contains("Favorites"));
        assertTrue(playlist.toString().contains("Mirrors"));
    }


    @Test
    void findSongExisting()
    {
        Playlist playlist = new Playlist("Favorites");
        Song song = new Song("Mirrors", "Justin Timberlake", "Pop");
        playlist.addSong(song);

        assertEquals(song, playlist.findSong("Mirrors"));
    }


    @Test
    void findSongIgnoresCaseAndSpaces()
    {
        Playlist playlist = new Playlist("Favorites");
        Song song = new Song("Mirrors", "Justin Timberlake", "Pop");
        playlist.addSong(song);

        assertEquals(song, playlist.findSong("  mirrors  "));
    }


    @Test
    void findSongNotFoundOrInvalid()
    {
        Playlist playlist = new Playlist("Favorites");
        playlist.addSong(new Song("Mirrors", "Justin Timberlake", "Pop"));

        assertNull(playlist.findSong("Unknown"));
        assertNull(playlist.findSong(""));
        assertNull(playlist.findSong(null));
    }


    @Test
    void getSongValidAndInvalidIndex()
    {
        Playlist playlist = new Playlist("Favorites");
        Song song = new Song("Mirrors", "Justin Timberlake", "Pop");
        playlist.addSong(song);

        assertEquals(song, playlist.getSong(0));
        assertNull(playlist.getSong(-1));
        assertNull(playlist.getSong(1));
    }


    @Test
    void getSongsSnapshotAndEmptyPlaylist()
    {
        Playlist playlist = new Playlist("Favorites");
        Song song = new Song("Mirrors", "Justin Timberlake", "Pop");
        playlist.addSong(song);

        Song[] snapshot = playlist.getSongs();

        assertEquals(1, snapshot.length);
        assertEquals(song, snapshot[0]);

        snapshot[0] = null;

        assertEquals(song, playlist.getSong(0));

        Playlist emptyPlaylist = new Playlist("Empty");
        assertEquals(0, emptyPlaylist.getSongs().length);
        assertEquals(0, emptyPlaylist.size());
    }


    @Test
    void containsSongExistingAndMissing()
    {
        Playlist playlist = new Playlist("Favorites");
        Song song = new Song("Mirrors", "Justin Timberlake", "Pop");
        Song missing = new Song("Dynamite", "BTS", "Pop");

        playlist.addSong(song);

        assertTrue(playlist.containsSong(song));
        assertFalse(playlist.containsSong(missing));
    }

}
