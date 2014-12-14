package spotify;

import java.util.*;

/**
 * Created by mislav on 11/18/14.
 */
public class ZipfsSong {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        List<Song> songs = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {

            long listenedToCount = input.nextLong();
            String name = input.next();
            songs.add(new Song(name, listenedToCount, i+1));
        }

        Collections.sort(songs, new Comparator<Song>() {
            @Override
            public int compare(Song song, Song song2) {

                int listenedExpectedCompare = Long.compare( song2.getListenedToCount() * song2.getOrder(), song.getListenedToCount() * song.getOrder());
                if(listenedExpectedCompare == 0){
                    return Long.compare(song.getOrder(), song2.getOrder());
                }
                return listenedExpectedCompare;
            }
        });

        for(int i = 0;i<m;i++){
            System.out.println(songs.get(i).getName());
        }
    }

    public static class Song{
        private String name;
        private long listenedToCount;
        private long order;

        public Song(String name, long listenedToCount, long order) {
            this.name = name;
            this.listenedToCount = listenedToCount;
            this.order = order;
        }

        public String getName() {
            return name;
        }

        public long getListenedToCount() {
            return listenedToCount;
        }

        public long getOrder() {
            return order;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "name='" + name + '\'' +
                    ", listenedToCount=" + listenedToCount +
                    ", order=" + order +
                    '}';
        }
    }
}
