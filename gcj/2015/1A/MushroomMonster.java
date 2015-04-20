// link: https://code.google.com/codejam/contest/4224486/dashboard#s=p0
// name: Mushroom Monster
package gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MushroomMonster {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("A-large-practice.in"));
		PrintWriter out = new PrintWriter(new File("A-large-practice.out"));
		int T = in.nextInt();

		for (int t = 0; t < T; t++) {

			int n = in.nextInt();

			int[] mushrooms = new int[n];

			for (int i = 0; i < n; i++) {
				mushrooms[i] = in.nextInt();
			}

			int maxDiff = 0;
			int totalDiff = 0;
			for (int i = 1; i < n; i++) {
				int diff = mushrooms[i - 1] - mushrooms[i];
				if (diff <= 0)
					continue;

				if (diff > maxDiff) {
					maxDiff = diff;
				}
				totalDiff += diff;
			}

			int constDiff = 0;

			for (int i = 0; i < n - 1; i++) {
				constDiff += Math.min(mushrooms[i], maxDiff);
			}
			out.println(String.format("Case #%d: %d %d", (t + 1), totalDiff, constDiff));
		}
		out.close();
		in.close();
	}
}
