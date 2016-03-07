// link: https://www.hackerrank.com/contests/worldcodesprint/challenges/powerplants-in-flatland
// name: FlatLand Space Station
import java.util.Scanner;

public class FlatLandSpaceStation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();


        boolean[] stations = new boolean[n];
        for (int i = 0; i < m; i++) {
            int station = in.nextInt();
            stations[station] = true;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        if(!stations[0]){
            left[0] = 10000000;
        }
        for (int i = 1; i < left.length; i++) {
            if(stations[i]){
                left[i]=0;
                continue;
            }
            left[i]=left[i-1]+1;
        }

        if(!stations[n-1]){
            right[n-1] = 10000000;
        }
        for(int i = right.length - 2; i>=0; i--){
            if(stations[i]){
                right[i]=0;
                continue;
            }
            right[i]= right[i+1] +1;
        }

        int max = 0;
        for(int i =0;i<n;i++){
            int current = Math.min(left[i], right[i]);
            if (current > max){
                max = current;
            }
        }
        if(max > n) max=n;
        System.out.println(max);
    }
}
