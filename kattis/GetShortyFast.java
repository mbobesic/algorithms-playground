package kattis;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class GetShortyFast {

	public static void main(String[] args) {

		Kattio io = new Kattio(System.in, System.out);

		while (true) {
			int n = io.getInt();
			int m = io.getInt();

			if (n == 0 && m == 0) {
				break;
			}

			ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				graph.add(new ArrayList<Pair>());
			}

			TreeSet<Pair> closest = new TreeSet<>();
			for (int i = 0; i < n; i++) {
				closest.add(new Pair(i, 0.));
			}

			for (int i = 0; i < m; i++) {

				int first = io.getInt();
				int second = io.getInt();
				double shrinkFactor = io.getDouble();
				graph.get(first).add(new Pair(second, shrinkFactor));
				graph.get(second).add(new Pair(first, shrinkFactor));
			}

			double[] height = new double[n];
			boolean[] visited = new boolean[n];

			height[0] = 1;
			closest.remove(new Pair(0, 0));
			closest.add(new Pair(0, 1));

			for (int i = 0; i < n - 1; i++) {
				Pair first = closest.pollFirst();
				if (first == null) {
					break;
				}
				int node = first.endVertex;
				double shrinkFactor = first.shrinkFactor;
				visited[node] = true;

				for (int j = 0; j < graph.get(node).size(); j++) {
					Pair pii = graph.get(node).get(j);

					if (!visited[pii.endVertex]) {
						if (height[pii.endVertex] < shrinkFactor * pii.shrinkFactor) {

							closest.remove(new Pair(pii.endVertex, height[pii.endVertex]));
							height[pii.endVertex] = shrinkFactor * pii.shrinkFactor;
							closest.add(new Pair(pii.endVertex, pii.shrinkFactor * shrinkFactor));
						}
					}
				}

			}
			System.out.println(String.format("%.4f", height[height.length - 1]));
		}

		io.close();

	}

	static class Pair implements Comparable<Pair> {

		int endVertex;
		double shrinkFactor;

		public Pair(int endVertex, double shrinkFactor) {
			this.endVertex = endVertex;
			this.shrinkFactor = shrinkFactor;
		}

		@Override
		public int compareTo(Pair o) {
			if (o.endVertex == this.endVertex) {
				return 0;
			}
			int compare = Double.compare(o.shrinkFactor, this.shrinkFactor);
			if (compare == 0) {
				return -1;
			}
			return compare;
		}

		@Override
		public String toString() {
			return "Pair [endVertex=" + endVertex + ", shrinkFactor=" + shrinkFactor + "]";
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
