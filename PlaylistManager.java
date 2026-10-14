public class PlaylistManager {

    private LinkedChain<Playlist> playlists;
    private LinkedChain<Song> listeningHistory;
    private LinkedChain<String> searchingHistory;

    public PlaylistManager() {
        playlists = new LinkedChain<>();
        listeningHistory = new LinkedChain<>();
        searchingHistory = new LinkedChain<>();
    }

//Creates a new playlist
public boolean createPlaylist(String name) {
 if (name == null || name.trim().isEmpty()) {
     throw new IllegalArgumentException("Invalid playlist name");
 }

 if (findPlaylist(name) != null) {
     return false;
 }

 return playlists.add(new Playlist(name));
}

//Removes an existing playlist
public boolean removePlaylist(String name) {
 Playlist playlist = findPlaylist(name);

 if (playlist == null) {
     return false;
 }

 return playlists.remove(playlist);
}

//Finds a playlist by name
public Playlist findPlaylist(String name) {
 if (name == null || name.trim().isEmpty()) {
     return null;
 }

 for (int i = 0; i < playlists.size(); i++) {
     Playlist playlist = playlists.get(i);

     if (playlist.getName().equals(name)) {
         return playlist;
     }
 }

 return null;
}
//Adds a song to an existing playlist
public boolean addSongToPlaylist(String playlistName, Song song) {
 if (song == null) {
     throw new IllegalArgumentException("Song cannot be null");
 }

 Playlist playlist = findPlaylist(playlistName);

 if (playlist == null) {
     return false;
 }

 return playlist.addSong(song);
}

//Removes a song from an existing playlist
public boolean removeSongFromPlaylist(String playlistName, Song song) {
 if (song == null) {
     throw new IllegalArgumentException("Song cannot be null");
 }

 Playlist playlist = findPlaylist(playlistName);

 if (playlist == null) {
     return false;
 }

 return playlist.removeSong(song);
}
//Searches for a song by title
public Song searchByTitle(String title) {
 if (title == null || title.trim().isEmpty()) {
     throw new IllegalArgumentException("Invalid song title");
 }

 recordSearch(title);

 for (int i = 0; i < playlists.size(); i++) {
     Playlist playlist = playlists.get(i);
     Song song = playlist.findSong(title);

     if (song != null) {
         return song;
     }
 }

 return null;
}

//Searches for a song by artist
public Song searchByArtist(String artist) {
 if (artist == null || artist.trim().isEmpty()) {
     throw new IllegalArgumentException("Invalid artist name");
 }

 recordSearch(artist);

 for (int i = 0; i < playlists.size(); i++) {
     Playlist playlist = playlists.get(i);

     for (int j = 0; j < playlist.size(); j++) {
         Song song = playlist.getSong(j);

         if (song.getArtist().equalsIgnoreCase(artist)) {
             return song;
         }
     }
 }

 return null;
}
//Records a song in the listening history
public void recordListening(Song song) {
 if (song == null) {
     throw new IllegalArgumentException("Song cannot be null");
 }

 listeningHistory.addToEnd(song);
}

//Records a search in the search history
public void recordSearch(String searchText) {
 if (searchText == null || searchText.trim().isEmpty()) {
     throw new IllegalArgumentException("Invalid search text");
 }

 searchingHistory.addToEnd(searchText);
}
//Returns how many times a song has been played
public int getPlayCount(Song song) {
 if (song == null) {
     throw new IllegalArgumentException("Song cannot be null");
 }

 return listeningHistory.count(song);
}

}