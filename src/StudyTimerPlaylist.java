import components.MusicPlaylist;
import components.MusicPlaylist1L;

/**
 * A small utility class to represent a study timer playlist.
 */
public class StudyTimerPlaylist {

    /**
     * The music playlist used in this study timer playlist.
     */
    private MusicPlaylist playlist;

    /**
     * The number of minutes allocated per song.
     */
    private int minutesPerSong;

    /**
     * Constructor for StudyTimerPlaylist.
     *
     * @param minutesPerSong
     */
    public StudyTimerPlaylist(int minutesPerSong) {
        assert minutesPerSong > 0 : "Violation of: minutesPerSong > 0";
        this.minutesPerSong = minutesPerSong;
        this.playlist = new MusicPlaylist1L();
    }

    /**
     * Adds a song to the playlist.
     *
     * @param song
     *            the song to be added
     */
    public void addSong(String song) {
        this.playlist.addSong(song);
    }

    /**
     * Calculates the total study time based on the number of songs and minutes
     * per song.
     *
     * @return the total study time in minutes
     */
    public int calculateStudyTime() {
        return this.playlist.numberOfSongs() * this.minutesPerSong;
    }

    /**
     * Returns a string representation of the StudyTimerPlaylist.
     */
    @Override
    public final String toString() {
        return "Study PLaylist lasts for " + this.calculateStudyTime()
                + " minutes. And includeds these songs: " + this.playlist;
    }

}
