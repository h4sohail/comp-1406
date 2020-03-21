import java.util.*;

public class MusicExchangeCenter {
    private ArrayList<User> users;
    private HashMap<String, Float> royalties;
    private ArrayList<Song> downloadedSongs;

    public MusicExchangeCenter() {
        users = new ArrayList<User>();
        royalties = new HashMap<String, Float>();
        downloadedSongs = new ArrayList<Song>();
    }

    public ArrayList<User> onlineUsers() {
        ArrayList<User> onlineUsers = new ArrayList<User>();
        for (User s : users) {
            if (s.isOnline()) {
                onlineUsers.add(s);
            }
        }
        return onlineUsers;
    }

    public ArrayList<Song> allAvailableSongs() {
        ArrayList<Song> availableSongs = new ArrayList<Song>();
        for (User u : onlineUsers()) {
            for (Song s : u.getSongList()) {
                availableSongs.add(s);
            }
        }
        return availableSongs;
    }

    public String toString() {
        return String.format("Music Exchange Center (%d users online, %d songs available)", onlineUsers().size(),
                allAvailableSongs().size());
    }

    public User userWithName(String s) {
        for (User u : users) {
            if (u.getUserName().equals(s)) {
                return u;
            }
        }
        return null;
    }

    public void registerUser(User x) {
        if (userWithName(x.getUserName()) == null) { // Check if a user with the same username exists
            users.add(x);
        }
    }

    public ArrayList<Song> availableSongsByArtist(String artist) {
        ArrayList<Song> availableSongs = new ArrayList<Song>();
        for (Song s : allAvailableSongs()) {
            if (s.getArtist().equals(artist)) {
                availableSongs.add(s);
            }
        }
        return availableSongs;
    }

    public Song getSong(String title, String ownerName) {
        User owner = null;
        for (User u : users) {
            if (u.getUserName().equals(ownerName)) {
                owner = u;
            }
        }

        if (owner == null) {
            return null;
        }
        if (!owner.isOnline()) {
            return null;
        }

        Song song = owner.songWithTitle(title);
        if (song == null) {
            return null;
        }

        downloadedSongs.add(song);
        if (!royalties.keySet().contains(song.getArtist())) {
            royalties.put(song.getArtist(), (float) 0.25);
        } else {
            royalties.replace(song.getArtist(), (float) (royalties.get(song.getArtist()) + 0.25));
        }
        return song;
    }

    public void displayRoyalties() {
        System.out.println(String.format("%-5s   %-15s", "AMOUNT", "ARTIST"));
        System.out.println("---------------");
        for (String key : royalties.keySet()) {
            System.out.println(String.format("$%-5.2f   %-15s", royalties.get(key), key));
        }
    }

    public ArrayList<Song> getDownloadedSongs() {
        return downloadedSongs;
    }

    public TreeSet<Song> uniqueDownloads() {
        return new TreeSet<>(downloadedSongs);
    }

    public ArrayList<Pair<Integer, Song>> songsByPopularity() {
        ArrayList<Pair<Integer, Song>> pairList = new ArrayList<Pair<Integer, Song>>();
        Iterator<Song> iterator = uniqueDownloads().iterator();
        while (iterator.hasNext()) {
            Song currSong = iterator.next();
            pairList.add(new Pair<>(currSong.getDownloads(), currSong));
        }

        Collections.sort(pairList, (p1, p2) -> p2.getKey().compareTo(p1.getKey()));
        return pairList;
    }
}
