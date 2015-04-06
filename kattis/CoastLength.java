// link: https://open.kattis.com/problems/coast
// name: Coast Length
package kattis;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class CoastLength {

	public static void main(String[] args) {

		Kattio io = new Kattio(System.in, System.out);
		int n = io.getInt();
		int m = io.getInt();

		boolean[][] field = new boolean[n][m];

		for (int i = 0; i < n; i++) {

			String word = io.getWord();
			for (int j = 0; j < word.length(); j++) {
				if (word.charAt(j) == '1') {

					field[i][j] = true;
				}
			}
		}
		boolean[][] visited = new boolean[n][m];

		Pair[] moves = { new Pair(-1, 0), new Pair(1, 0), new Pair(0, -1), new Pair(0, 1) };

		int result = 0;
		Queue<Pair> q = new ArrayDeque<>();
		List<Pair> starting = generateStarters(n, m);
		for (Pair start : starting) {

			if (!visited[start.x][start.y] || field[start.x][start.y]) {

				q.add(start);
				visited[start.x][start.y] = true;
			}

			while (!q.isEmpty()) {

				Pair currentPosition = q.poll();

				if (field[currentPosition.x][currentPosition.y]) {
					// edge land
					result += 1;
					continue;
				}

				assert (!field[currentPosition.x][currentPosition.y]);

				for (Pair move : moves) {

					int newX = currentPosition.x + move.x;
					int newY = currentPosition.y + move.y;

					if (newX < 0 || newX >= n) {
						continue;
					}

					if (newY < 0 || newY >= m) {
						continue;
					}

					if (field[newX][newY]) {
						result += 1;
						continue;
					}

					if (!visited[newX][newY]) {

						q.add(new Pair(newX, newY));
						visited[newX][newY] = true;
					}
				}
			}
		}
		io.print(result);
		io.close();
	}

	private static List<Pair> generateStarters(int n, int m) {

		List<Pair> result = new ArrayList<>();
		for (int i = 0; i < m; i++) {

			result.add(new Pair(0, i));
			result.add(new Pair(n - 1, i));
		}

		for (int i = 0; i < n; i++) {

			result.add(new Pair(i, 0));
			result.add(new Pair(i, m - 1));
		}

		return result;
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static class Kattio extends PrintWriter {
		public Kattio(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public Kattio(InputStream i, OutputStream o) {
			super(new BufferedOutputStream(o));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public boolean hasMoreTokens() {
			return peekToken() != null;
		}

		public int getInt() {
			return Integer.parseInt(nextToken());
		}

		public double getDouble() {
			return Double.parseDouble(nextToken());
		}

		public long getLong() {
			return Long.parseLong(nextToken());
		}

		public String getWord() {
			return nextToken();
		}

		private BufferedReader r;
		private String line;
		private StringTokenizer st;
		private String token;

		private String peekToken() {
			if (token == null)
				try {
					while (st == null || !st.hasMoreTokens()) {
						line = r.readLine();
						if (line == null)
							return null;
						st = new StringTokenizer(line);
					}
					token = st.nextToken();
				} catch (IOException e) {}
			return token;
		}

		private String nextToken() {
			String ans = peekToken();
			token = null;
			return ans;
		}
	}
}
