// link: https://code.google.com/codejam/contest/6224486/dashboard#s=p2
// name: Dijkstra
package gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Dijkstra {

	private static int[][] matrix = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 2, 3, 4 }, { 0, 2, -1, 4, -3 }, { 0, 3, -4, -1, 2 }, { 0, 4, 3, -2, -1 } };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("C-large-practice.in"));
		PrintWriter out = new PrintWriter(new File("C-large-practice.out"));
		int T = in.nextInt();

		for (int t = 0; t < T; t++) {

			long L = in.nextLong();
			long X = in.nextLong();

			String line = in.next();

			int state = 1;

			for (long i = 0; i < L * (X % 4); i++) {
				int position = (int) (i % L);
				state = get_new_state(state, get_int_rep(line.charAt(position)));
			}

			if (state != -1) {
				out.println(String.format("Case #%d: %s", (t + 1), "NO"));
				continue;
			}

			long reps = Math.max(X, 4);

			long i_position = -1;
			state = 1;
			for (long i = 0; i < L * reps; i++) {
				int position = (int) (i % L);
				state = get_new_state(state, get_int_rep(line.charAt(position)));
				
				if (state == 2) {

					i_position = i;
					break;
				}
			}

			if (i_position == -1) {
				out.println(String.format("Case #%d: %s", (t + 1), "NO"));
				continue;
			}
			state = 1;
			long j_position = -1;
			for (long i = i_position + 1; i < i_position + L * reps; i++) {

				int position = (int) (i % L);
				state = get_new_state(state, get_int_rep(line.charAt(position)));

				if (state == 3) {

					j_position = i;
					break;
				}
			}
	
			if (j_position >= 0 && j_position < L * X)
				out.println(String.format("Case #%d: %s", (t + 1), "YES"));
			else
				out.println(String.format("Case #%d: %s", (t + 1), "NO"));

		}
		in.close();
		out.close();
	}

	private static int get_new_state(int state, int int_rep) {
		if (state < 0) {
			state *= -1;
			return -1 * matrix[state][int_rep];
		}
		return state = matrix[state][int_rep];

	}

	private static int get_int_rep(char c) {
		if (c == 'i')
			return 2;
		if (c == 'j')
			return 3;
		if (c == 'k')
			return 4;
		return 0;
	}

}
