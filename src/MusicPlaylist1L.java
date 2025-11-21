import java.util.Iterator;

import components.queue.Queue;
import components.queue.Queue1L;

public class MusicPlaylist1L extends MusicPlaylistSecondary {
    /*
     * Private members -------------------------------------------------
     */
    /**
     * Representation of {@code this}.
     */
    private Queue<String> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new Queue1L<String>();
    }

    /*
     * Constructors ---------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public MusicPlaylist1L() {
        this.createNewRep();
    }

    /*
     * Standard methods ------------------------------------------------
     */
    @Override
    public final MusicPlaylist<String> newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot contruct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(MusicPlaylist<String> source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof MusicPlaylist1L : ""
                + "Violation of: source is of dynamic type MusicPlaylist1L";

        MusicPlaylist1L localSource = (MusicPlaylist1L) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel methods --------------------------------------------------
     */
    @Override
    public final void addSong(String song) {
        assert song != null : "Violation of: song is not null";
        this.rep.enqueue(song);
    }

    @Override
    public final String removeFirstSong() {
        assert this.numberOfSongs() > 0 : "Violation of: playlist is not empty";
        return this.rep.dequeue();
    }

    @Override
    public final int numberOfSongs() {
        return this.rep.length();
    }

    @Override
    public final class MusicPlaylist1LIterator implements Iterator<String> {
        /**
         * The queue of songs to iterate through.
         */
        private Queue<String> iterQueue;

        /*
         * Constructors ---------------------------------------------------
         */

        /**
         * No-argument constructor.
         */
        public MusicPlaylistIterator() {
            this.iterQueue = new Queue1L<String>();
            Queue<String> tempQueue = MusicPlaylist1L.this.rep.newInstance();
            tempQueue.transferFrom(MusicPlaylist1L.this.rep);
            while (tempQueue.length() > 0) {
                String song = tempQueue.dequeue();
                this.iterQueue.enqueue(song);
            }
        }
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj instanceof MusicPlaylist1L) {
            MusicPlaylist1L other = (MusicPlaylist1L) obj;
            return this.rep.equals(other.rep);
        } else {
            return false;
        }
    }

}
