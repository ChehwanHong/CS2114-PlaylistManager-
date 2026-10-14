import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PlaylistManager manager = new PlaylistManager();

        boolean running = true;

        while (running)
        {
            System.out.println("\n===== Playlist Manager =====");
            System.out.println("1. Create Playlist");
            System.out.println("2. Remove Playlist");
            System.out.println("3. Add Song");
            System.out.println("4. Remove Song");
            System.out.println("5. View Playlist Songs");
            System.out.println("6. Search by Title");
            System.out.println("7. Search by Artist");
            System.out.println("8. Record Listening");
            System.out.println("9. View Listening History");
            System.out.println("10. View Search History");
            System.out.println("11. Listening Statistics");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice)
            {
                case "1":
                    System.out.print("Playlist name: ");
                    String name = scanner.nextLine();

                    try
                    {
                        if (manager.createPlaylist(name))
                        {
                            System.out.println("Playlist created!");
                        }
                        else
                        {
                            System.out.println("Could not create playlist.");
                        }
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println(
                            "Invalid playlist name. Please try again.");
                    }

                    break;

                case "2":
                    System.out.print("Playlist name: ");
                    name = scanner.nextLine();

                    if (manager.removePlaylist(name))
                    {
                        System.out.println("Playlist removed!");
                    }
                    else
                    {
                        System.out.println("Playlist not found.");
                    }
                    break;

                case "3":
                    System.out.print("Playlist name: ");
                    name = scanner.nextLine();

                    Playlist playlist = manager.findPlaylist(name);

                    if (playlist == null)
                    {
                        System.out.println("Playlist not found.");
                        break;
                    }

                    Song song = readSong(scanner);

                    if (song != null && playlist.addSong(song))
                    {
                        System.out.println("Song added!");
                    }
                    break;

                case "4":
                    System.out.print("Playlist name: ");
                    name = scanner.nextLine();

                    playlist = manager.findPlaylist(name);

                    if (playlist == null)
                    {
                        System.out.println("Playlist not found.");
                        break;
                    }

                    System.out.print("Song title: ");
                    String title = scanner.nextLine();

                    Song existingSong = playlist.findSong(title);

                    if (existingSong != null
                        && playlist.removeSong(existingSong))
                    {
                        System.out.println("Song removed!");
                    }
                    else
                    {
                        System.out.println("Song not found.");
                    }
                    break;

                case "5":
                    System.out.print("Playlist name: ");
                    name = scanner.nextLine();

                    playlist = manager.findPlaylist(name);

                    if (playlist == null)
                    {
                        System.out.println("Playlist not found.");
                    }
                    else if (playlist.isEmpty())
                    {
                        System.out.println("Playlist is empty.");
                    }
                    else
                    {
                        System.out.println(playlist);
                    }
                    break;

                case "6":
                    System.out.print("Enter song title: ");
                    String searchTitle = scanner.nextLine();

                    try
                    {
                        Song foundSong = manager.searchByTitle(searchTitle);

                        if (foundSong != null)
                        {
                            System.out.println("Found: " + foundSong);
                        }
                        else
                        {
                            System.out.println("Song not found.");
                        }
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out
                            .println("Invalid song title. Please try again.");
                    }
                    break;

                case "7":
                    System.out.print("Enter artist name: ");
                    String searchArtist = scanner.nextLine();

                    try
                    {
                        Song artistSong = manager.searchByArtist(searchArtist);

                        if (artistSong != null)
                        {
                            System.out.println("Found: " + artistSong);
                        }
                        else
                        {
                            System.out
                                .println("No songs found for this artist.");
                        }
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out
                            .println("Invalid artist name. Please try again.");
                    }
                    break;

                case "8":
                    System.out.print("Enter song title: ");
                    String playTitle = scanner.nextLine();

                    try
                    {
                        Song playSong = manager.searchByTitle(playTitle);

                        if (playSong != null)
                        {
                            manager.recordListening(playSong);
                            System.out
                                .println("Listening recorded: " + playSong);
                        }
                        else
                        {
                            System.out.println("Song not found.");
                        }
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out
                            .println("Invalid song title. Please try again.");
                    }
                    break;

                case "9":
                    Song[] listeningHistory = manager.getListeningHistory();

                    if (listeningHistory.length == 0)
                    {
                        System.out.println("No listening history yet.");
                    }
                    else
                    {
                        System.out.println("===== Listening History =====");

                        for (Song historySong : listeningHistory)
                        {
                            System.out.println(historySong);
                        }
                    }
                    break;

                case "10":
                    String[] searchHistory = manager.getSearchHistory();

                    if (searchHistory.length == 0)
                    {
                        System.out.println("No search history yet.");
                    }
                    else
                    {
                        System.out.println("===== Search History =====");

                        for (String search : searchHistory)
                        {
                            System.out.println(search);
                        }
                    }
                    break;

                case "11":
                    System.out.print("Enter song title: ");
                    String statsTitle = scanner.nextLine();

                    try
                    {
                        Song statsSong = manager.searchByTitle(statsTitle);

                        if (statsSong != null)
                        {
                            int playCount = manager.getPlayCount(statsSong);
                            System.out.println("Play count: " + playCount);
                        }
                        else
                        {
                            System.out.println("Song not found.");
                        }
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out
                            .println("Invalid song title. Please try again.");
                    }
                    break;

                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }
        }

        scanner.close();
    }


    private static Song readSong(Scanner scanner)
    {
        System.out.print("Song title: ");
        String title = scanner.nextLine();

        System.out.print("Artist: ");
        String artist = scanner.nextLine();

        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        try
        {
            return new Song(title, artist, genre);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid song: " + e.getMessage());
            return null;
        }
    }
}
