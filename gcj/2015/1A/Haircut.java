// link: https://code.google.com/codejam/contest/4224486/dashboard#s=p1&a=1
// name: haircut
package gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Haircut {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("B-large-practice.in"));
		PrintWriter out = new PrintWriter(new File("B-large-practice.out"));
		int T = in.nextInt();

		for (int t = 0; t < T; t++) {

			int b = in.nextInt();
			long n = in.nextLong();

			long[] m = new long[b];
			for (int i = 0; i < b; i++) {
				m[i] = in.nextLong();
			}

			long lower = 0;
			long upper = 10000L * n;

			while (lower < upper) {
				long middle = (lower + upper) / 2;

				if (getCut(middle, m) >= n) {
					upper = middle;
				} else {
					lower = middle + 1;
				}
			}


			long prev = getCut(lower - 1, m);
			long diff = n - prev;
			int result = -1;
			for (int i = 0; i < m.length; i++) {

				if (lower % m[i] == 0) {
					diff--;
					if (diff == 0) {
						result = i + 1;
						break;
					}
				}
			}

			out.println(String.format("Case #%d: %d", (t + 1), result));
		}

		in.close();
		out.close();
	}

	private static long getCut(long middle, long[] m) {
		if (middle < 0) {
			return 0;
		}
		long result = 0;
		for (int index = 0; index < m.length; index++) {
			result += middle / m[index] + 1;
		}
		return result;
	}
}
