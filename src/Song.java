import java.util.Objects;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
        if (nextSong == null) {
            return false;
        }
        var next = this.nextSong;
        var next2 = next.nextSong;
        while (next2 != null) {
            if (this == next2 || next == next2) {
                return true;
            }
            next = next.nextSong;
            next2 = next2.nextSong;
            if (next2 != null) {
                next2 = next2.nextSong;
            }

        }

        return false;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(name, song.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");
        Song third = new Song("dddddd");

        first.setNextSong(second);
        second.setNextSong(third);
        third.setNextSong(second);

        System.out.println(first.isRepeatingPlaylist());
    }
}
