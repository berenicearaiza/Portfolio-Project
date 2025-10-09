import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class MusicPlaylist {

    private Queue<String> playlist;

    private int songCount;

    public MusicPlaylist() {
        this.playlist = new Queue1L<>();
        this.songCount = 0; // No song is playing initially
    }

    private void addSong(String song) {
        // Code to add a song to the end of the playlist
        this.playlist.enqueue(song);
    }

    private String removeFirstSong() {
        String firstSong = this.playlist.dequeue();
        this.songCount--;
        return firstSong;
    }

    public boolean hasNoSongs() {
        return this.playlist.length() == 0;
    }

    public void skipSong(int distance) {
        //rotates the queue to skip songs
        //depending on the amount of songs (distance) to skip
        this.playlist.rotate(distance);
    }

    public String currentSong() {
        //get the last song added to the playlist
        Queue<String> tempQueue = new Queue1L<>();

        //flip the queue to access the last song
        for (int i = 0; i < this.playlist.length() - 1; i++) {
            tempQueue.enqueue(this.playlist.dequeue());
        }

        String lastSong = tempQueue.dequeue();

        //restore the original queue
        while (tempQueue.length() > 0) {
            this.playlist.enqueue(tempQueue.dequeue());
        }
        this.playlist.enqueue(lastSong);

        return lastSong;
    }

    public void shufflePlaylist() {
        //shuffle the playlist randomly
        //still needs work since this is not necessarily random
        int n = this.playlist.length();
        for (int i = 0; i < n; i++) {
            //random index to rotate by
            int randomIndex = (int) (Math.random() * n);
            this.playlist.rotate(randomIndex);
            this.playlist.enqueue(this.playlist.dequeue());

        }
    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        //initialize playlist
        MusicPlaylist playlist = new MusicPlaylist();

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
        out.println("Current song: " + playlist.currentSong());

        //skip 1 song and display current song
        out.println("Skipping 1 song...");
        playlist.skipSong(1);
        out.println("Current song: " + playlist.currentSong());

        //shuffle playlist and display current song
        out.println("Shuffling playlist...");
        playlist.shufflePlaylist();
        out.println("Current song: " + playlist.currentSong());

        //remove first song and display current song
        out.println("Removing first song: " + playlist.removeFirstSong());
        out.println("Current song: " + playlist.currentSong());

        //say bye
        out.println("Thanks for using and creating your playlist, "
                + playlistName + "!");
        out.println("BYE!");

        in.close();
        out.close();
    }

}
