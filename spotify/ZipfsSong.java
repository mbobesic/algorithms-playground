package spotify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by mislav on 11/18/14.
 */
public class ZipfsSong {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Song> songs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
        	
            st = new StringTokenizer(br.readLine());
            long listenedToCount = Long.parseLong(st.nextToken());
            String name = st.nextToken();
            songs.add(new Song(name, listenedToCount*(i+1), i + 1));
        }

        TreeSet<Song> result = new TreeSet<spotify.ZipfsSong.Song>(new Comparator<Song>() {
            @Override
            public int compare(Song song, Song song2) {

                long listenedExpectedCompare = song2.quality - song.quality;
                if (listenedExpectedCompare == 0) {
                    return song.order - song2.order;
                }
                if (listenedExpectedCompare < 0)
                	return -1;
                return 1;
            }
        });
        
        for (Song song : songs){
        	result.add(song);
        	if(result.size() > m){
        		result.pollLast();
        	}
        }
        

        for (Song current : result) {
            System.out.println(current.name);
        }
        br.close();
    }

    static class Song {
        String name;
        long quality;
        int order;

        public Song(String name, long quality, int order) {
            this.name = name;
            this.quality = quality;
            this.order = order;
        }

    }
}
