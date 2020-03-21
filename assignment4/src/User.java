import java.util.ArrayList;

public class User {
    private String userName;
    private boolean online;
    private ArrayList<Song> songList;


    public User() {
        this("");
    }

    public User(String u) {
        songList = new ArrayList<Song>();
        userName = u;
        online = false;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isOnline() {
        return online;
    }


    public String toString() {
        String s = "" + userName + ": " + songList.size() + " songs (";
        if (!online) {
            s += "not ";
        }
        return s + "online)";
    }

    public void addSong(Song s) {
        s.setOwner(this);
        songList.add(s);
    }

    public int totalSongTime() {
        int duration = 0;
        for (Song s : songList) {
            duration += s.getDuration();
        }
        return duration;
    }

    public void register(MusicExchangeCenter m) {
        m.registerUser(this);
    }

    public void logon() {
        this.online = true;
    }

    public void logoff() {
        this.online = false;
    }

    public Song songWithTitle(String title) {
        for (Song s : songList) {
            if (s.getTitle().equals(title)) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<String> requestCompleteSonglist(MusicExchangeCenter m) {
        ArrayList<String> songList = new ArrayList<String>();
        int counter = 1;
        songList.add(String.format("    %-30s %-15s  %-5s %-15s", "TITLE", "ARTIST", "TIME", "OWNER"));
        for (Song x : m.allAvailableSongs()) {
            String s = String.format("%2d. %-30s %-15s %2d:%02d  %-15s", counter, x.getTitle(), x.getArtist(),
                    x.getMinutes(), x.getSeconds(), x.getOwner().getUserName());
            songList.add(s);
            counter++;
        }
        return songList;
    }

    public ArrayList<String> requestSonglistByArtist(MusicExchangeCenter m, String artist) {
        ArrayList<String> songList = new ArrayList<String>();
        int counter = 1;
        songList.add(String.format("    %-30s %-15s  %-5s %-15s", "TITLE", "ARTIST", "TIME", "OWNER"));
        for (Song x : m.availableSongsByArtist(artist)) {
            String s = String.format("%2d. %-30s %-15s %2d:%02d  %-15s", counter, x.getTitle(), x.getArtist(),
                    x.getMinutes(), x.getSeconds(), x.getOwner().getUserName());
            songList.add(s);
            counter++;
        }
        return songList;
    }

    public void downloadSong(MusicExchangeCenter m, String title, String ownerName) {
        Song s = m.getSong(title, ownerName);
        if (s != null) {
            songList.add(s);
            s.setDownloads(s.getDownloads() + 1);
        }
    }
}
