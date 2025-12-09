import components.MusicPlaylist;
import components.MusicPlaylist1L;

/**
 * Customized JUnit test fixture for MusicPlaylist1L.
 */
public final class MusicPlaylist1LTest extends MusicPlaylistTest {
    @Override
    protected MusicPlaylist constructorTest() {
        return new MusicPlaylist1L();
    }

    @Override
    protected MusicPlaylist constructorRef() {
        return new MusicPlaylist1L();
    }
}
