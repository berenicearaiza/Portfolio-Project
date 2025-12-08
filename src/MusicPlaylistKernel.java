import components.standard.Standard;

public interface MusicPlaylistKernel extends Standard<MusicPlaylist> {
    /**
     * Music Playlist kernel component with primary methods.
     *
     *
     */

    /**
     * Adds a song to the end of the playlist.
     *
     * @param song
     *            the entry to be added
     * @aliases reference song
     * @updates this
     * @ensures MusicPlaylist = MusicPlaylist + <song>
     */
    void addSong();

    /**
     * Removes the first song from the playlist.
     *
     * @returns the song that was removed
     * @updates playlist
     * @requires playlist has at least one song
     * @ensures MusicPlaylist = MusicPlaylist with song removed
     */
    String removeFirstSong();

    /**
     * Skips the current song and moves to the next song in the playlist.
     *
     * @updates playlist
     * @requires playlist has at least one song
     * @ensures MusicPlaylist = MusicPlaylist with first song moved to end
     */
    void skipSong();

    /**
     * Reports the number of songs in the playlist.
     *
     * @return number of songs in the playlist
     * @ensures numberOfSongs = length of MusicPlaylist
     */
    int numberOfSongs();
}
