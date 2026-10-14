import static org.junit.jupiter.api.Assertions.*;
 
import org.junit.jupiter.api.Test;
 
public class SongTest {

  @Test
  void constructorValid(){
    Song song = new Song("Mirrors", "Justin Timberlake", "Pop");
    assertNotNull(song);
  }

  @Test
  void constructorNullTitle(){
    assertThrows(IllegalArgumentException.class, () -> new Song(null, "Justin Timberlake", "Pop"));
  }

  @Test
  void constructorEmptyTitle(){
    assertThrows(IllegalArgumentException.class, () -> new Song("", "Justin Timberlake", "Pop"));
  }

  @Test
  void constructorNullArtist(){
    assertThrows(IllegalArgumentException.class, () -> new Song("Mirrors", null, "Pop"));
  }

  @Test
  void constructorEmptyArtist(){
    assertThrows(IllegalArgumentException.class, () -> new Song("Mirrors", "", "Pop"));
  }

  @Test 
  void getters(){
    Song song = new Song("Mirrors", "Justin Timberlake", "Pop");
    assertEquals("Mirrors", song.getTitle());
    assertEquals("Justin Timberlake", song.getArtist());
    assertEquals("Pop", song.getGenre());
  }

  @Test 
  void gettersMinimalValues(){
    Song song = new Song("A", "B", "C");
    assertEquals("A", song.getTitle());
    assertEquals("B", song.getArtist());
    assertEquals("C", song.getGenre());
  }

  @Test
  void equalsSameSong(){
    assertTrue(new Song("Mirrors", "Justin Timberlake", "Pop").equals(new Song("Mirrors", "Justin Timberlake", "Pop")));
  }

  @Test
  void equalsDifferentSong(){
    assertFalse(new Song("Mirrors", "Justin Timberlake", "Pop").equals(new Song("SexyBack", "Justin Timberlake", "Pop")));
  }

  @Test
  void equalsNull(){
    assertFalse(new Song("Mirrors", "Justin Timberlake", "Pop").equals(null));
  }

   @Test
  void toStringContainsInfo(){
    String text = new Song("Mirrors", "Justin Timberlake", "Pop").toString();
    assertTrue(text.contains("Mirrors"));
    assertTrue(text.contains("Justin Timberlake")); 
    assertTrue(text.contains("Pop"));
  }

@Test
  void toStringMinimalSong(){
    assertNotNull(new Song("A", "B", "C").toString());
  }
            
}

@Test
void constructorWhitespaceTitle() {
    assertThrows(IllegalArgumentException.class,
        () -> new Song("   ", "Justin Timberlake", "Pop"));
}

@Test
void constructorWhitespaceArtist() {
    assertThrows(IllegalArgumentException.class,
        () -> new Song("Mirrors", "   ", "Pop"));
}

@Test
void equalsIgnoreCase() {
    Song song1 = new Song("Mirrors", "Justin Timberlake", "Pop");
    Song song2 = new Song("MIRRORS", "JUSTIN TIMBERLAKE", "Pop");

    assertTrue(song1.equals(song2));
}

@Test
void equalsDifferentGenre() {
    Song song1 = new Song("Mirrors", "Justin Timberlake", "Pop");
    Song song2 = new Song("Mirrors", "Justin Timberlake", "Rock");

    assertFalse(song1.equals(song2));
}

