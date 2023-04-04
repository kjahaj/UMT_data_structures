import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
public class Playlist {
        private LinkedList<Song> playlist;

        public Playlist(LinkedList<Song> playlist) {
            this.playlist = playlist;
        }

        public void addSong(Song song){
            if(playlist.contains(song)){
                System.out.println("Song already exists");
            }
            else {
                playlist.add(song);
                System.out.println("Song added");
            }
        }

        public void deleteSong(Song song){
            if(playlist.contains(song)){
                playlist.remove(song);
                System.out.println("Song removed");
            }
            else System.out.println("Song not found");
        }

        public void playPlaylist(){
            System.out.println(playlist);
        }

        public void shuffle(){
            Collections.shuffle(playlist);
            System.out.println("Shuffled playlist: ");
            System.out.println(playlist);
        }

        public double playlistDuration(){
            double totalMinutes = 0.0;
            for (Song song : playlist) {
                totalMinutes += song.getDuration();
            }
            return totalMinutes*60;
        }

        public void sortByDuration(){
            playlist.sort(new Comparator<>() {
                @Override
                public int compare(Song o1, Song o2) {
                    return Double.compare(o1.getDuration(), o2.getDuration());
                }
            });
            Collections.reverse(playlist);
            System.out.println(playlist);
        }

    }
