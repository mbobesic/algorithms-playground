// link: https://code.google.com/codejam/contest/6224486/dashboard#s=p0
// name: Standing Ovation
package gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class StandingOvation {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("btest.in"));
		PrintWriter out = new PrintWriter(new File("btest.out"));
		int T = in.nextInt();

		for (int t = 0; t < T; t++) {

			TreeSet<Integer> numbers = new TreeSet<>(Collections.reverseOrder());
			int size = in.nextInt();

			for (int i = 0; i < size; i++) {
				int nextInt = in.nextInt();
				numbers.add(nextInt);
			}

			int sleeps = 0;
			int best_result = numbers.first();

			while (true) {
				if (numbers.first() <= 3) {
					break;
				}

				Integer first = numbers.pollFirst();
				Integer a = first / 2;
				Integer b = first - a;
				numbers.add(a);
				numbers.add(b);

				sleeps++;
				if (sleeps + numbers.first() < best_result) {
					best_result = sleeps + numbers.first();
				}
			}

			out.println(String.format("Case #%d: %d", (t + 1), best_result));
		}
		out.close();
		in.close();
	}
}
