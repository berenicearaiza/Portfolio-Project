import java.util.Comparator;

public interface MusicPlaylist extends MusicPlaylistKernel {
    /**
     * Reports whether the playlist has no songs.
     *
     * @return true if playlist has no songs, false otherwise
     * @ensures hasNoSongs = (length of MusicPlaylist = 0)
     */
    boolean hasNoSongs();

    /**
     * Shuffles the songs in the playlist randomly.
     *
     * @updates playlist
     * @ensures MusicPlaylist = a random order of MusicPlaylist
     */
    void shufflePlaylist();

    /**
     * Sorts the songs in the playlist based on comparator (artist or title).
     *
     * @ensures MusicPlaylist = MusicPlaylist sorted according to order
     * @param order
     *            the comparator defining the order (by artist or by title)
     */
    void sortPlaylist(Comparator<String> order);

    /**
     * Reports the first song in the playlist without removing it.
     *
     * @return the first song in the playlist
     * @aliases reference firstSong
     * @requires playlist has at least one song
     * @ensures firstSong = the first song in MusicPlaylist
     */
    String firstSong();

    /**
     * Brings the song with the given title to the front.
     *
     * @param songTitle
     *           the title of the song to be played (brought to the front)
     * @updates playlist
     * @requires song with given title is in the playlist
     * @ensures the song with title songTitle is now the first song in MusicPlaylist
     */
    void playSong(String songTitle);

}
