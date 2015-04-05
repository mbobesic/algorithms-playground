// link: https://open.kattis.com/problems/winningstreak
// name: Winning Streak
package kattis;

import java.util.Scanner;

public class WinningStreak {

	public static void main(String[] args) {

		Scanner io = new Scanner(System.in);

		for (int t = 0; t < 5; t++) {
			if (!io.hasNextInt()) {
				break;
			}
			int matchesCount = io.nextInt();
			double winningProbability = io.nextDouble();

			solve(matchesCount, winningProbability);
		}
		io.close();
	}

	private static void solve(int matchesCount, double winningProbability) {
		double lossProbability = 1 - winningProbability;
		double[] winProbabilities = new double[matchesCount + 1];
		winProbabilities[0] = 1;

		for (int i = 1; i < winProbabilities.length; i++) {

			winProbabilities[i] = winProbabilities[i - 1] * winningProbability;
		}

		double[][] streakByMatch = new double[matchesCount + 1][matchesCount + 1];

		for (int match = 0; match < matchesCount + 1; match++) {

			for (int streak = 0; streak < matchesCount + 1; streak++) {
				if (streak >= match) {

					streakByMatch[match][streak] = 1;
					continue;
				}
				if (streak + 1 == match) {
					streakByMatch[match][streak] = 1 - winProbabilities[match];
					continue;
				}
				streakByMatch[match][streak] = streakByMatch[match - 1][streak];

				if (match - streak - 2 >= 0) {
					streakByMatch[match][streak] -= streakByMatch[match - streak - 2][streak] * lossProbability * winProbabilities[streak + 1];
				}
			}
		}

		double result = 0.;
		for (int i = 1; i < matchesCount + 1; i++) {
			result += i * (streakByMatch[matchesCount][i] - streakByMatch[matchesCount][i - 1]);
		}
		System.out.println(result);
	}
}
