public class Song {
    private String title;
    private String artist;
    private double duration;

    public Song(String title, String artist, double duration) {
        setTitle(title);
        setArtist(artist);
        setDuration(duration);
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Title: "+title+"    Artist: "+artist+"      Duration: "+duration;
    }
}
