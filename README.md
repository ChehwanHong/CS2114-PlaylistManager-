# CS2114-PlaylistManager-
A playlist manager application for CS 2114 Project 2, Group 24.

## How to Run

1. Open the project in Eclipse.
2. Run Main.java as a Java Application.
3. Follow the console menu to use the Playlist Manager.

## How to Run Tests

1. Right-click SongTest.java, PlaylistTest.java, or PlaylistManagerTest.java.
2. Select Run As → JUnit Test.
3. Check that all tests pass.

## Reflection

### What changed from our specification?

Our original plan was to use LinkedChain mainly for listening history. During implementation, we decided to use LinkedChain for three different purposes: storing playlists, listening history, and search history.

We also added a getPlayCount() method to count how many times a song was played. This helped us complete part of our Listening Statistics stretch goal.

We added input validation for invalid playlist names, song titles, and artists. We also wrote JUnit tests to check normal operations and invalid inputs.

### What changed in LinkedChain?

We used the provided LinkedChain class without changing its implementation. Its existing methods were enough for managing playlists, songs, and histories.

### What happened to our unknowns?

We were able to solve the six unknowns from our original specification.

We learned how to use LinkedChain with different data types, manage multiple playlists, search for songs, remove songs safely, and record listening and search histories.

We also confirmed that listening history can store the same song multiple times.

### What doesn't work yet?

All of our planned MVP features have been implemented and connected to the console menu in Main.java.

We tested creating and removing playlists, adding and removing songs, searching by title and artist, and viewing listening and search histories.

Our JUnit tests for Song, Playlist, and PlaylistManager also passed.

We implemented a basic Listening Statistics feature that shows how many times a song has been played.

The remaining stretch goals, such as advanced filtering and mood categories, have not been implemented.



Next steps —lay out what you will do next to extend this prototype toward the final.



What is left to finish the MVP? The remaining features and fixes, in the order you will do them.

The PlaylistManager class contains all requirements for the MVP, including viewing songs in a playlist and search history. These features have now been connected to Main.java, allowing users to interact with the program through a console menu. We will continue testing the complete application and fixing any issues we find.



Which stretch goals will you attempt? The ones from your scope you are committing to, and the ones you are dropping.

Our group had four strectch goals: Listening statistics, Advanced filtering, Mood categories, and Music recommendation.
We are attempting to do listening statistics, advanced filtering, and mood categories. Advanced filtering and mood categories are fairly similar, and will require looping through a playlist or playlists, finding songs based on their genre value, and returning them. We have implemented a basic listening statistics feature using getPlayCount(), which counts how many times a song has been played. Music recommendation was broad as defined and also seems significantly more complex compared to other stretch goals, so it is unlikely we will get to it.



What new tests will you need? The methods and bad-input cases the added work must cover.

Our JUnit tests for Song, Playlist, and PlaylistManager have passed. We have also tested the main features through the console menu. We will continue testing edge cases and add new tests for any stretch goals we implement, especially advanced filtering and mood categories. These tests will include invalid inputs, empty playlists, and searches that return no matching songs.



Who does what? Which team member owns each remaining item.
Chehwan will continue testing the PlaylistManager and Main classes and fix any remaining bugs. Josiah will work on improving Playlist features and related tests. Kaitlyn will help test Song functionality and support advanced filtering. Luke will help with console menu testing and README updates. The team will work together on the remaining stretch goals.

## Attribution

| File | Contributor | Contribution |
|---|---|---|
| Song.java | Kaitlyn | Wrote the class. |
| SongTest.java | Kaitlyn | Wrote tests. |
| Playlist.java | Josiah | Wrote the class. |
| PlaylistTest.java | Josiah | Wrote the tests. |
| PlaylistManager.java | Chehwan | Implemented the class. |
| PlaylistManagerTest.java | Chehwan | Wrote tests. |
| Main.java | Luke | Implemented the console menu. |
| README | Chehwan and Luke | Wrote and revised the Reflection, Next Steps, and Attribution sections. |
| LinkedChain.java | Course-provided | Used without modifications. |

### GenAI Usage

We used GenAI to assist with debugging, reviewing Java code, and improving input validation throughout the project. For example, GenAI helped us identify a better way to handle invalid song inputs in the readSong() method of Main.java. GenAI was used as a supporting tool, while the final implementation and design decisions were made by us.


## System Diagram

![Playlist Manager System Diagram](Playlist%20Manager.png)
  
