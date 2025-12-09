import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.MusicPlaylist;

/**
 * JUnit test class for MusicPlaylist1L.
 *
 * @author Berenice Araiza Sierra
 */
public abstract class MusicPlaylistTest {
    /**
     * Returns a new instance of the MusicPlaylist type being tested.
     *
     * @return new instance of MusicPlaylist
     */
    protected abstract MusicPlaylist constructorTest();

    /**
     * Returns a new instance of the reference MusicPlaylist type.
     *
     * @return new instance of reference MusicPlaylist
     */
    protected abstract MusicPlaylist constructorRef();

    /**
     * Creates and returns a MusicPlaylist of the type being tested.
     *
     * @param songTitles
     * @return new MusicPlaylist containing the given song titles
     */
    private MusicPlaylist createFromArgsTest(String... songTitles) {
        MusicPlaylist playlist = this.constructorTest();
        for (String s : songTitles) {
            playlist.addSong(s);
        }
        return playlist;
    }

    /**
     * Creates and returns a reference MusicPlaylist.
     *
     * @param songTitles
     * @return new reference MusicPlaylist containing the given song titles
     */
    private MusicPlaylist createFromArgsRef(String... songTitles) {
        MusicPlaylist playlist = this.constructorRef();
        for (String s : songTitles) {
            playlist.addSong(s);
        }
        return playlist;
    }

    /**
     * Test hasNoSongs on an empty playlist.
     */
    @Test
    public void testHasNoSongsEmpty() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest();
        MusicPlaylist pExpected = this.createFromArgsRef();

        boolean result = p.hasNoSongs();
        boolean resultExpected = pExpected.hasNoSongs();
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
        assertEquals(resultExpected, result);
    }

    /**
     * Test hasNoSongs on a playlist with one Song.
     */
    @Test
    public void testHasNoSongsOne() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest("Song A");
        MusicPlaylist pExpected = this.createFromArgsRef("Song A");

        boolean result = p.hasNoSongs();
        boolean resultExpected = pExpected.hasNoSongs();
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
        assertEquals(resultExpected, result);
    }

    /**
     * Test hasNoSongs on a playlist with multiple songs.
     */
    @Test
    public void testHasNoSongsMultiple() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest("Song A", "Song B", "Song C",
                "Song D");
        MusicPlaylist pExpected = this.createFromArgsRef("Song A", "Song B",
                "Song C", "Song D");

        boolean result = p.hasNoSongs();
        boolean resultExpected = pExpected.hasNoSongs();
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
        assertEquals(resultExpected, result);
    }

    /**
     * Test addSongs() on an empty playlist.
     */
    @Test
    public void testAddSongEmpty() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest();
        MusicPlaylist pExpected = this.createFromArgsRef("Song A");

        p.addSong("Song A");
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
    }

    /**
     * Test addSongs() on a playlist with one song.
     */
    @Test
    public void testAddSongOne() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest("Song A");
        MusicPlaylist pExpected = this.createFromArgsRef("Song A", "Song B");

        p.addSong("Song B");
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
    }

    /**
     * Test addSongs() on a playlist with multiple Songs.
     */
    @Test
    public void testAddSongMultiple() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest("Song A", "Song B", "Song C");
        MusicPlaylist pExpected = this.createFromArgsRef("Song A", "Song B",
                "Song C", "Song D");

        p.addSong("Song D");
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
    }

    /**
     * Test numberOfSongs() on a playlist with no songs.
     */
    @Test
    public void testNumberOfSongsEmpty() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest();
        MusicPlaylist pExpected = this.createFromArgsRef();

        int result = p.numberOfSongs();
        int resultExpected = pExpected.numberOfSongs();
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
        assertEquals(resultExpected, result);
    }

    /**
     * Test numberOfSongs() on a playlist with one song.
     */
    @Test
    public void testNumberOfSongsOne() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest("Song A");
        MusicPlaylist pExpected = this.createFromArgsRef("Song A");

        int result = p.numberOfSongs();
        int resultExpected = pExpected.numberOfSongs();
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
        assertEquals(resultExpected, result);
    }

    /**
     * Test numberOfSongs() on a playlist with multiple songs.
     */
    @Test
    public void testNumberOfSongsMultiple() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest("Song A", "Song B", "Song C",
                "Song D");
        MusicPlaylist pExpected = this.createFromArgsRef("Song A", "Song B",
                "Song C", "Song D");

        int result = p.numberOfSongs();
        int resultExpected = pExpected.numberOfSongs();
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
        assertEquals(resultExpected, result);
    }

    /**
     * Test removeFirstSong() on a playlist with one song.
     */
    @Test
    public void testRemoveFirstSongOne() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest("Song A");
        MusicPlaylist pExpected = this.createFromArgsRef();

        p.removeFirstSong();
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
    }

    /**
     * Test removeFirstSong() on a playlist with multiple songs.
     */
    @Test
    public void testRemoveFirstSongMultiple() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest("Song A", "Song B", "Song C",
                "Song D");
        MusicPlaylist pExpected = this.createFromArgsRef("Song B", "Song C",
                "Song D");

        p.removeFirstSong();
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
    }

    /**
     * Test skipSong() on a playlist with multiple songs.
     */
    @Test
    public void testSkipSongMultiple() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest("Song A", "Song B", "Song C",
                "Song D");
        MusicPlaylist pExpected = this.createFromArgsRef("Song B", "Song C",
                "Song D", "Song A");

        p.skipSong();
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
    }

    /**
     * Test firstSong() on a playlist with one songs.
     */
    @Test
    public void testFirstSongOne() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest("Song A");
        MusicPlaylist pExpected = this.createFromArgsRef("Song A");

        String result = p.firstSong();
        String resultExpected = pExpected.firstSong();
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
        assertEquals(resultExpected, result);
    }

    /**
     * Test firstSong() on a playlist with multiple songs.
     */
    @Test
    public void testFirstSongMultiple() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest("Song A", "Song B", "Song C");
        MusicPlaylist pExpected = this.createFromArgsRef("Song A", "Song B",
                "Song C");

        String result = p.firstSong();
        String resultExpected = pExpected.firstSong();
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
        assertEquals(resultExpected, result);
    }

    /**
     * Test playSong() on a playlist with multiple songs.
     */
    @Test
    public void testPlaySongMultiple() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest("Song A", "Song B", "Song C",
                "Song D");
        MusicPlaylist pExpected = this.createFromArgsRef("Song A", "Song B",
                "Song D");

        p.playSong("Song C");
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
    }

    /**
     * Test clear() on a playlist with one song.
     */
    @Test
    public void testClear() {
        /*
         * Set up test and expected values.
         */
        MusicPlaylist p = this.createFromArgsTest("Song A");
        MusicPlaylist pExpected = this.createFromArgsRef();
        p.clear();
        /*
         * Assert the values of variables match their expected values.
         */
        assertEquals(pExpected, p);
    }

}
