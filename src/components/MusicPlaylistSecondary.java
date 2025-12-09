package components;

import java.util.Random;

/**
 * A secondary implementation of the MusicPlaylist interface. This class
 * provides additional functionalities such as shuffling and sorting the
 * playlist.
 */
public abstract class MusicPlaylistSecondary implements MusicPlaylist {
    @Override
    public final boolean hasNoSongs() {
        //return true if the playlist has no songs, false otherwise
        return this.numberOfSongs() == 0;
    }

    /*
     * Shuffles the playlist using the Fisher-Yates algorithm.
     */
    @Override
    public final void shufflePlaylist() {
        // Implementing Fisher-Yates shuffle algorithm
        int n = this.numberOfSongs();

        // If there are 0 or 1 songs, no need to shuffle
        if (n <= 1) {
            return;
        }

        String[] songs = new String[n];
        for (int i = 0; i < n; i++) {
            songs[i] = this.removeFirstSong();
        }

        Random rand = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String temp = songs[i];
            songs[i] = songs[j];
            songs[j] = temp;
        }

        // Re-add the shuffled songs back to the playlist
        for (int i = 0; i < n; i++) {
            this.addSong(songs[i]);
        }
    }

    /*
     * Sorts the playlist by song title using the Bubble Sort algorithm.
     */
    @Override
    public final void sortPlaylistByTitle() {
        // Implementing Bubble Sort algorithm
        int n = this.numberOfSongs();
        if (n <= 1) {
            return;
        }
        // Extract songs into an array

        String[] songs = new String[n];
        for (int i = 0; i < n; i++) {
            songs[i] = this.removeFirstSong();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (songs[j].compareTo(songs[j + 1]) > 0) {
                    String temp = songs[j];
                    songs[j] = songs[j + 1];
                    songs[j + 1] = temp;
                }
            }
        }

        // Re-add the sorted songs back to the playlist
        for (int i = 0; i < n; i++) {
            this.addSong(songs[i]);
        }
    }

    /*
     * Sorts the playlist by artist name using the Bubble Sort algorithm.
     */
    @Override
    public final void sortPlaylistByArtist() {
        // Implementing Bubble Sort algorithm based on artist names
        int n = this.numberOfSongs();
        if (n <= 1) {
            return;
        }

        // Extract songs into an array
        String[] songs = new String[n];
        for (int i = 0; i < n; i++) {
            songs[i] = this.removeFirstSong();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String artist1 = songs[j].split(" - ")[0];
                String artist2 = songs[j + 1].split(" - ")[0];
                if (artist1.compareTo(artist2) > 0) {
                    String temp = songs[j];
                    songs[j] = songs[j + 1];
                    songs[j + 1] = temp;
                }
            }
        }

        // Re-add the sorted songs back to the playlist
        for (int i = 0; i < n; i++) {
            this.addSong(songs[i]);
        }
    }

    /*
     * Returns the first song in the playlist without removing it.
     */
    @Override
    public final String firstSong() {
        assert this.numberOfSongs() > 0 : "Playlist is empty";

        // Rotate the playlist to get the first song
        String first = this.removeFirstSong();
        this.addSong(first);
        return first;

    }

    /*
     * Plays the specified song by title, removing it from the playlist.
     */
    @Override
    public final void playSong(String songTitle) {
        assert this.numberOfSongs() > 0 : "Playlist is empty";
        assert songTitle != null : "Song title cannot be null";

        // Rotate the playlist to find and play the specified song
        int n = this.numberOfSongs();
        boolean found = false;

        // Go through the playlist
        for (int i = 0; i < n; i++) {
            String currentSong = this.removeFirstSong();
            if (currentSong.equals(songTitle) && !found) {
                found = true;
            } else {
                this.addSong(currentSong);
            }
        }
    }

    /*
     * Returns a string representation of the playlist.
     */
    @Override
    public final String toString() {
        // Create a string representation of the playlist
        StringBuilder sb = new StringBuilder();
        int n = this.numberOfSongs();
        for (int i = 0; i < n; i++) {
            String song = this.removeFirstSong();
            sb.append(song);
            if (i < n - 1) {
                sb.append(", ");
            }
            this.addSong(song);
        }
        return sb.toString();
    }

    /*
     * Checks if this playlist is equal to another playlist.
     */

    @Override
    public boolean equals(Object obj) {
        // Check for reference equality
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MusicPlaylist)) {
            return false;
        }
        MusicPlaylist other = (MusicPlaylist) obj;
        if (this.numberOfSongs() != other.numberOfSongs()) {
            return false;
        }
        // Compare songs one by one

        int n = this.numberOfSongs();
        boolean isEqual = true;

        for (int i = 0; i < n; i++) {
            String song1 = this.removeFirstSong();
            String song2 = other.removeFirstSong();
            if (!song1.equals(song2)) {
                isEqual = false;
            }
            this.addSong(song1);
            other.addSong(song2);
        }

        return isEqual;

    }

}
