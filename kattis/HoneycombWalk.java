// link: https://open.kattis.com/problems/honey
// name: Honeycomb Walk
import java.util.Scanner;

public class HoneycombWalk {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] input = new int[N];

        for (int n = 0; n < N; n++) {
            input[n] = in.nextInt();
        }

        int max = max(input);
        int[][][] results = new int[2 * max+1][2 * max+1][max+1];

        results[max][max][0] = 1;
        for (int step = 1; step < max + 1; step++) {
            for (int x = 0; x < 2 * max; x++) {
                for (int y = 0; y < 2 * max; y++) {

                    if (y > 0)
                        results[x][y][step] += results[x][y - 1][step - 1];

                    if (x > 0)
                        results[x][y][step] += results[x - 1][y][step - 1];

                    if (x > 0 && y > 0)
                        results[x][y][step] += results[x - 1][y - 1][step - 1];

                    if (x < 2 * max + 1)
                        results[x][y][step] += results[x + 1][y][step - 1];
                    if (y < 2 * max + 1)
                        results[x][y][step] += results[x][y + 1][step - 1];
                    if (x < 2 * max + 1 && y < 2 * max + 1)
                        results[x][y][step] += results[x + 1][y + 1][step - 1];
                }
            }
        }

        for (int x : input){
            System.out.println(results[max][max][x]);
        }
        in.close();
    }

    private static int max(int[] input) {
        int max = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > max) {
                max = input[i];
            }
        }
        return max;
    }
}
