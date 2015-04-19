// link: https://code.google.com/codejam/contest/6224486/dashboard#s=p3
// name: Ominous Omino
package gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class OminousOmino {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("D-large-practice.in"));
		PrintWriter out = new PrintWriter(new File("D-large-practice.out"));
		int T = in.nextInt();

		for (int t = 0; t < T; t++) {

			int x = in.nextInt();
			int r = in.nextInt();
			int c = in.nextInt();
			boolean rch = is_possible(x, r, c);
			if (rch)
				out.println(String.format("Case #%d: %s", (t + 1), "RICHARD"));
			else
				out.println(String.format("Case #%d: %s", (t + 1), "GABRIEL"));
		}
		out.close();
		in.close();
	}

	private static boolean is_possible(int x, int r, int c) {

		if (x >= 7) {
			return true;
		}

		if (r * c % x != 0) {
			return true;
		}

		int two_lengths = (x - 1) / 2 + 1;

		if (two_lengths > r || two_lengths > c) {

			return true;
		}

		if (x > r && x > c) {
			return true;
		}

		int min = Math.min(r, c);
		if (min > 1 && min <= x / 2) {
			return true;
		}

		if (Math.max(r, c) == 5 && min == 3 && x == 5)
			return true;
		return false;
	}
}
