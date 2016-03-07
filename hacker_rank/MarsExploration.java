// link: https://www.hackerrank.com/contests/worldcodesprint/challenges/save-our-ship
// name: Mars Exploration
import java.util.Scanner;

public class MarsExploration {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String S = in.next();
        char [] sos = new char[]{'S', 'O', 'S'};
        int result = 0;
        for (int i =0;i<S.length();i++){
            char t = S.charAt(i);
            if (t!=sos[i%3]){
                result++;
            }
        }
        System.out.println(result);
    }
}
