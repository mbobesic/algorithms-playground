// link: https://code.google.com/codejam/contest/6224486/dashboard#s=p1
// name: Infinite House Of Pancakes
package gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InfiniteHouseOfPancakes {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("B-large-practice.in"));
		PrintWriter out = new PrintWriter(new File("B-large-practice.out"));
		int T = in.nextInt();

		for (int t = 0; t < T; t++) {

			int D = in.nextInt();

			int[] diners = new int[D];
			int max = -1;
			for (int i = 0; i < D; i++) {
				diners[i] = in.nextInt();
				if (diners[i] > max)
					max = diners[i];
			}
			int best_result = max;
			for (int starting_pancakes = 1; starting_pancakes < max; starting_pancakes++) {
				
				int temp = starting_pancakes;
				for(Integer diner : diners){
					temp += (diner-1)/starting_pancakes;
				}
				best_result = Math.min(best_result, temp);
			}

			out.println(String.format("Case #%d: %d", (t + 1), best_result));
		}
		out.close();
		in.close();
	}
}
