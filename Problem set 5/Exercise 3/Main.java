import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Song song = new Song("Sonne","Rammstein",4.32);
        Song song1 = new Song("The Unforgiven","Metallica",6.26);
        Song song2 = new Song("Chop Suey!","System Of A Down",3.30);
        Song song3 = new Song("Loosing My Religion","R.E.M.",4.48);

        LinkedList<Song> metalSongs = new LinkedList<>();
        Playlist metalPlaylist = new Playlist(metalSongs);
                                        //Outputs:
        metalPlaylist.addSong(song);    //Song added
        metalPlaylist.addSong(song1);   //Song added
        metalPlaylist.addSong(song2);   //Song added
        metalPlaylist.addSong(song3);   //Song added



        metalPlaylist.playPlaylist();
        /*Output of playPlaylist (displays every song in added order):

        [Title: Sonne    Artist: Rammstein      Duration: 4.32,
         Title: The Unforgiven    Artist: Metallica      Duration: 6.26,
         Title: Chop Suey!    Artist: System Of A Down      Duration: 3.3,
         Title: Loosing My Religion    Artist: R.E.M.      Duration: 4.48]
         */



        metalPlaylist.shuffle();
        /*Output of shuffling:

        [Title: The Unforgiven    Artist: Metallica      Duration: 6.26,
         Title: Loosing My Religion    Artist: R.E.M.      Duration: 4.48,
         Title: Chop Suey!    Artist: System Of A Down      Duration: 3.3,
         Title: Sonne    Artist: Rammstein      Duration: 4.32]
         */


        metalPlaylist.sortByDuration();
        /*Output of sorting by longest duration(can be easily done by the shortest
        by just removing Collections.reverse in the corresponding function):

        [Title: The Unforgiven    Artist: Metallica      Duration: 6.26,
         Title: Loosing My Religion    Artist: R.E.M.      Duration: 4.48,
         Title: Sonne    Artist: Rammstein      Duration: 4.32,
         Title: Chop Suey!    Artist: System Of A Down      Duration: 3.3]
         */



        System.out.println("Playlist duration in seconds : " +metalPlaylist.playlistDuration()+" seconds");
        /*Output for playlist duration in seconds:
        Playlist duration in seconds : 1101.6 seconds
         */



                                            //Output:
        metalPlaylist.deleteSong(song);     //Song removed

    }

}