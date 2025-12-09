import components.MusicPlaylist;
import components.MusicPlaylist1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Demo class to showcase the functionality of MusicPlaylist1L.
 */
public final class MusicPlaylistDemo {
    /**
     * Private constructor to prevent instantiation.
     */
    private MusicPlaylistDemo() {

    }

    /**
     * Main method to run the demo.
     *
     * @param args
     */
    public static void main(String[] args) {
        //initialize playlist
        MusicPlaylist playlist = new MusicPlaylist1L();

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        //get playlist name
        out.println("Welcome to Your Personal Music Playlist!");
        out.println("Enter your playlist name: ");
        String playlistName = in.nextLine();

        //adding songs
        out.println("Adding songs to " + playlistName + "...");
        playlist.addSong("By Design - Kid Cudi feat. André 3000");
        playlist.addSong("Soy Peor - Bad Bunny");
        playlist.addSong("Awkward - Dance Gavin Dance");
        playlist.addSong("Pluto - Björk");
        playlist.addSong("Like Eating Glass - Bloc Party");
        playlist.addSong("Midnight Show - The Killers");
        out.println("Songs added!");

        //check if playlist is empty
        out.println("Is the playlist empty? " + playlist.hasNoSongs());

        //display current song
        out.println("Current song: " + playlist.firstSong());
        //skip 1 song and display current song
        out.println("Skipping 1 song...");
        playlist.skipSong();
        out.println("Current song: " + playlist.firstSong());

        //shuffle playlist and display current song
        out.println("Shuffling playlist...");
        playlist.shufflePlaylist();
        out.println("Current song: " + playlist.firstSong());

        //remove first song and display current song
        out.println("Removing first song: " + playlist.removeFirstSong());
        out.println("Current song: " + playlist.firstSong());

        //say bye
        out.println("Thanks for using and creating your playlist, "
                + playlistName + "!");
        out.println("BYE!");

        in.close();
        out.close();

    }
}
