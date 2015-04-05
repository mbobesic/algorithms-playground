// link: https://www.hackerrank.com/challenges/candies
// name: Candies
package hacker_rank;

import java.util.Scanner;

/**
 * 
 * Alice is a kindergarden teacher. She wants to give some candies to the
 * children in her class. All the children sit in a line, and each of them has a
 * rating score according to his or her performance in the class. Alice wants to
 * give at least 1 candy to each child. If two children sit next to each other,
 * then the one with the higher rating must get more candies. Alice wants to
 * save money, so she needs to minimize the total number of candies.
 * 
 * Input The first line of the input is an integer N, the number of children in
 * Alice's class. Each of the following N lines contains an integer that
 * indicates the rating of each child.
 * 
 * Ouput Output a single line containing the minimum number of candies Alice
 * must buy.
 * 
 * Constraints 1 <= N <= 10^5, 1 <= rating[i] <= 10^5
 * 
 * @author mislav
 * 
 */

public class Candies {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int[] ratings = new int[n];
		for (int i = 0; i < n; i++) {

			ratings[i] = in.nextInt();
		}

		int[] left = new int[n];
		int[] right = new int[n];

		for (int i = 1; i < n; i++) {

			if (ratings[i] > ratings[i - 1]) {
				left[i] = left[i - 1] + 1;
			}
		}

		for (int i = n - 2; i >= 0; i--) {

			if (ratings[i] > ratings[i + 1]) {
				right[i] = right[i + 1] + 1;
			}
		}
		int solution = 0;
		for (int i = 0; i < n; i++) {
			solution += Math.max(left[i], right[i]) + 1;
		}

		System.out.print(solution);

		in.close();
	}
}
