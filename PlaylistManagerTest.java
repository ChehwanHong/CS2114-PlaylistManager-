import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlaylistManagerTest {

    @Test
    public void testCreatePlaylist() {
        PlaylistManager manager = new PlaylistManager();

        assertTrue(manager.createPlaylist("Favorites"));
        assertNotNull(manager.findPlaylist("Favorites"));
    }

    @Test
    public void testCreatePlaylistInvalidName() {
        PlaylistManager manager = new PlaylistManager();

        assertThrows(IllegalArgumentException.class, () -> {
            manager.createPlaylist("");
        });
    }

    @Test
    public void testCreateDuplicatePlaylist() {
        PlaylistManager manager = new PlaylistManager();

        assertTrue(manager.createPlaylist("Favorites"));
        assertFalse(manager.createPlaylist("Favorites"));
    }
@Test
public void testFindPlaylist() {
    PlaylistManager manager = new PlaylistManager();
    manager.createPlaylist("Favorites");

    assertNotNull(manager.findPlaylist("Favorites"));
    assertNull(manager.findPlaylist("Missing"));
}

@Test
public void testRemovePlaylist() {
    PlaylistManager manager = new PlaylistManager();
    manager.createPlaylist("Favorites");

    assertTrue(manager.removePlaylist("Favorites"));
    assertNull(manager.findPlaylist("Favorites"));
}

@Test
public void testRemoveMissingPlaylist() {
    PlaylistManager manager = new PlaylistManager();

    assertFalse(manager.removePlaylist("Missing"));
}

@Test
public void testAddSongToPlaylist() {
    PlaylistManager manager = new PlaylistManager();
    manager.createPlaylist("Favorites");

    Song song = new Song("Dynamite", "BTS", "Pop");

    assertTrue(manager.addSongToPlaylist("Favorites", song));
    assertTrue(manager.findPlaylist("Favorites").containsSong(song));
}

@Test
public void testAddSongToMissingPlaylist() {
    PlaylistManager manager = new PlaylistManager();
    Song song = new Song("Dynamite", "BTS", "Pop");

    assertFalse(manager.addSongToPlaylist("Missing", song));
}

@Test
public void testRemoveSongFromPlaylist() {
    PlaylistManager manager = new PlaylistManager();
    manager.createPlaylist("Favorites");

    Song song = new Song("Dynamite", "BTS", "Pop");
    manager.addSongToPlaylist("Favorites", song);

    assertTrue(manager.removeSongFromPlaylist("Favorites", song));
    assertFalse(manager.findPlaylist("Favorites").containsSong(song));
}

@Test
public void testRemoveMissingSong() {
    PlaylistManager manager = new PlaylistManager();
    manager.createPlaylist("Favorites");

    Song song = new Song("Dynamite", "BTS", "Pop");

    assertFalse(manager.removeSongFromPlaylist("Favorites", song));
}

@Test
public void testSearchByTitle() {
    PlaylistManager manager = new PlaylistManager();
    manager.createPlaylist("Favorites");

    Song song = new Song("Dynamite", "BTS", "Pop");
    manager.addSongToPlaylist("Favorites", song);

    assertEquals(song, manager.searchByTitle("Dynamite"));
}

@Test
public void testSearchByTitleNotFound() {
    PlaylistManager manager = new PlaylistManager();

    assertNull(manager.searchByTitle("Unknown"));
}

@Test
public void testSearchByArtist() {
    PlaylistManager manager = new PlaylistManager();
    manager.createPlaylist("Favorites");

    Song song = new Song("Dynamite", "BTS", "Pop");
    manager.addSongToPlaylist("Favorites", song);

    assertEquals(song, manager.searchByArtist("BTS"));
}

@Test
public void testSearchByArtistNotFound() {
    PlaylistManager manager = new PlaylistManager();

    assertNull(manager.searchByArtist("Unknown"));
}

@Test
public void testRecordListening() {
    PlaylistManager manager = new PlaylistManager();
    Song song = new Song("Dynamite", "BTS", "Pop");

    manager.recordListening(song);

    assertEquals(1, manager.getPlayCount(song));
}

@Test
public void testRecordListeningNull() {
    PlaylistManager manager = new PlaylistManager();

    assertThrows(IllegalArgumentException.class, () -> {
        manager.recordListening(null);
    });
}

@Test
public void testRecordSearchInvalid() {
    PlaylistManager manager = new PlaylistManager();

    assertThrows(IllegalArgumentException.class, () -> {
        manager.recordSearch("");
    });
}

@Test
public void testListeningStatistics() {
    PlaylistManager manager = new PlaylistManager();
    Song song = new Song("Dynamite", "BTS", "Pop");

    manager.recordListening(song);
    manager.recordListening(song);
    manager.recordListening(song);

    assertEquals(3, manager.getPlayCount(song));
}

@Test
public void testListeningStatisticsEmpty() {
    PlaylistManager manager = new PlaylistManager();
    Song song = new Song("Dynamite", "BTS", "Pop");

    assertEquals(0, manager.getPlayCount(song));
}
@Test
public void testFindPlaylistInvalidName() {
    PlaylistManager manager = new PlaylistManager();

    assertNull(manager.findPlaylist(null));
    assertNull(manager.findPlaylist(""));
}

@Test
public void testSearchByTitleInvalidInput() {
    PlaylistManager manager = new PlaylistManager();

    assertThrows(IllegalArgumentException.class,
        () -> manager.searchByTitle(""));
}

@Test
public void testSearchByArtistInvalidInput() {
    PlaylistManager manager = new PlaylistManager();

    assertThrows(IllegalArgumentException.class,
        () -> manager.searchByArtist(null));
}

@Test
public void testAddNullSong() {
    PlaylistManager manager = new PlaylistManager();
    manager.createPlaylist("Favorites");

    assertThrows(IllegalArgumentException.class,
        () -> manager.addSongToPlaylist("Favorites", null));
}

@Test
public void testRemoveNullSong() {
    PlaylistManager manager = new PlaylistManager();
    manager.createPlaylist("Favorites");

    assertThrows(IllegalArgumentException.class,
        () -> manager.removeSongFromPlaylist("Favorites", null));
}

@Test
public void testRecordSearchValid() {
    PlaylistManager manager = new PlaylistManager();

    assertDoesNotThrow(() -> manager.recordSearch("BTS"));
}

@Test
public void testGetPlayCountNull() {
    PlaylistManager manager = new PlaylistManager();

    assertThrows(IllegalArgumentException.class,
        () -> manager.getPlayCount(null));
}

@Test
public void testGetListeningHistory() {
    PlaylistManager manager = new PlaylistManager();
    Song song = new Song("Dynamite", "BTS", "Pop");

    manager.recordListening(song);
    manager.recordListening(song);

    Song[] history = manager.getListeningHistory();

    assertEquals(2, history.length);
    assertEquals(song, history[0]);
    assertEquals(song, history[1]);
}

@Test
public void testGetListeningHistoryEmpty() {
    PlaylistManager manager = new PlaylistManager();

    assertEquals(0, manager.getListeningHistory().length);
}

@Test
public void testGetListeningHistorySnapshot() {
    PlaylistManager manager = new PlaylistManager();
    Song song = new Song("Dynamite", "BTS", "Pop");

    manager.recordListening(song);
    Song[] history = manager.getListeningHistory();
    history[0] = null;

    assertEquals(1, manager.getListeningHistory().length);
    assertEquals(song, manager.getListeningHistory()[0]);
}

@Test
public void testGetSearchHistory() {
    PlaylistManager manager = new PlaylistManager();

    manager.recordSearch("BTS");
    manager.recordSearch("Dynamite");

    String[] history = manager.getSearchHistory();

    assertEquals(2, history.length);
    assertEquals("BTS", history[0]);
    assertEquals("Dynamite", history[1]);
}

@Test
public void testGetSearchHistoryEmpty() {
    PlaylistManager manager = new PlaylistManager();

    assertEquals(0, manager.getSearchHistory().length);
}

@Test
public void testGetSearchHistorySnapshot() {
    PlaylistManager manager = new PlaylistManager();
    manager.recordSearch("BTS");

    String[] history = manager.getSearchHistory();
    history[0] = "Changed";

    assertEquals("BTS", manager.getSearchHistory()[0]);
}

@Test
public void testSearchByArtistWithSpaces() {
    PlaylistManager manager = new PlaylistManager();
    manager.createPlaylist("Favorites");

    Song song = new Song("Dynamite", "BTS", "Pop");
    manager.addSongToPlaylist("Favorites", song);

    assertEquals(song, manager.searchByArtist("  BTS  "));
}

@Test
public void testSearchByArtistIgnoringCase() {
    PlaylistManager manager = new PlaylistManager();
    manager.createPlaylist("Favorites");

    Song song = new Song("Dynamite", "BTS", "Pop");
    manager.addSongToPlaylist("Favorites", song);

    assertEquals(song, manager.searchByArtist("bts"));
}

@Test
public void testGetSongsSnapshot() {
    Playlist playlist = new Playlist("Favorites");
    Song song = new Song("Dynamite", "BTS", "Pop");
    playlist.addSong(song);

    Song[] songs = playlist.getSongs();

    assertEquals(1, songs.length);
    assertEquals(song, songs[0]);

    songs[0] = null;

    assertEquals(song, playlist.getSong(0));
}

@Test
public void testGetSongsEmpty() {
    Playlist playlist = new Playlist("Favorites");

    assertEquals(0, playlist.getSongs().length);
}

}