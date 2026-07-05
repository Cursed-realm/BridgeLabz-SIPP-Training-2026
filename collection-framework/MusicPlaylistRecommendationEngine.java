import java.util.LinkedList;

public class MusicPlaylistRecommendationEngine {
    private LinkedList<String> recentlyPlayed;
    private static final int MAX_HISTORY_SIZE = 10;

    public MusicPlaylistRecommendationEngine() {
        recentlyPlayed = new LinkedList<String>();
    }

    public void playSong(String songName) {
        if (songName == null || songName.trim().isEmpty()) {
            throw new IllegalArgumentException("Song name must not be empty");
        }
        recentlyPlayed.addFirst(songName);
        if (recentlyPlayed.size() > MAX_HISTORY_SIZE) {
            recentlyPlayed.removeLast();
        }
    }

    public boolean searchSong(String songName) {
        if (songName == null || songName.trim().isEmpty()) {
            throw new IllegalArgumentException("Song name must not be empty");
        }
        return recentlyPlayed.contains(songName);
    }

    public void displayRecentlyPlayed() {
        System.out.println("Recently Played Songs:");
        for (String song : recentlyPlayed) {
            System.out.println(song);
        }
    }

    public static void main(String[] args) {
        MusicPlaylistRecommendationEngine playlistEngine = new MusicPlaylistRecommendationEngine();

        String[] songs = {
            "Shape of You", "Blinding Lights", "Levitating", "Perfect",
            "Believer", "Faded", "Sunflower", "Closer",
            "Senorita", "Circles", "Memories"
        };

        for (String song : songs) {
            playlistEngine.playSong(song);
        }

        System.out.println("Is 'Shape of You' in history: " + playlistEngine.searchSong("Shape of You"));

        playlistEngine.displayRecentlyPlayed();
    }
}
