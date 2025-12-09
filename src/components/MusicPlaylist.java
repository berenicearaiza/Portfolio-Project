package components;

/**
 * An interface for a music playlist.
 *
 * @author Berenice Araiza Sierra
 *
 */
public interface MusicPlaylist extends MusicPlaylistKernel {
    /**
     * Reports whether the playlist has no songs.
     *
     * @return true if playlist has no songs, false otherwise
     * @ensures hasNoSongs = (length of MusicPlaylist = 0)
     */
    boolean hasNoSongs();

    /**
     * Reports the first song in the playlist and moves it to the end.
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
     *            the title of the song to be played (brought to the front)
     * @updates playlist
     * @requires song with given title is in the playlist
     * @ensures the song with title songTitle is now the first song in
     *          MusicPlaylist
     */
    void playSong(String songTitle);

    /**
     * Sorts the playlist by song title.
     */
    void sortPlaylistByTitle();

    /**
     * Sorts the playlist by artist name.
     *
     * @updates playlist
     * @ensures MusicPlaylist is sorted by artist name
     */
    void sortPlaylistByArtist();

    /**
     * Shuffles the playlist randomly.
     *
     * @updates playlist
     * @ensures MusicPlaylist is randomly shuffled
     */
    void shufflePlaylist();

}
