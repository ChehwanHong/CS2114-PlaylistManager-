# CS2114-PlaylistManager-
A playlist manager application for CS 2114 Project 2, Group 24.



















Next steps —lay out what you will do next to extend this prototype toward the final.



What is left to finish the MVP? The remaining features and fixes, in the order you will do them.

The PlaylistManager class contains all requirements for the MVP other than viewing songs in a playlist and search history. These features will simply require looping through a chain and displaying what it contains in a neat, app-like format. Given the similar nature of these two requirements, they will be completed simultaneously.



Which stretch goals will you attempt? The ones from your scope you are committing to, and the ones you are dropping.

Our group had four MVP’s: Listening statistics, Advanced filtering, Mood categories, and Music recommendation.
We are attempting to do listening statistics, advanced filtering, and mood categories. Advanced filtering and mood categories are fairly similar, and will require looping through a playlist or playlists, finding songs based on their genre value, and returning them. Listening statistics, we also plan to implement. Music recommendation was broad as defined and also seems significantly more complex compared to other stretch goals, so it is unlikely we will get to it.



What new tests will you need? The methods and bad-input cases the added work must cover.

We will need tests for viewing songs and search history, as well as stretch goals we implement. Song and playlist viewing tests will require making small playlists with a small search history, and ensuring our outputs match what is expected, while covering cases of null (ex: a playlist without a search history yet). Stretch goals we plan to implement will require test cases to make sure we can properly filter by artist and genre most importantly. We would need to cover input cases of searching for genres/artists that don’t exist in the playlist or at all. We also would need to cover returning the most played song in an empty playlist, while testing to make sure the most played song(s) is returned.



Who does what? Which team member owns each remaining item.
