// link: https://open.kattis.com/problems/railway
// name: Toy Railway
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

public class ToyRailway {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);

		int n = io.getInt();
		int m = io.getInt();

		HashMap<String, List<String>> translations = new HashMap<>();
		for (int i = 1; i < n + 1; i++) {
			String ia = i + "A";
			String ib = i + "B";
			String ic = i + "C";
			String[] temp = { ib, ic };

			translations.put(ia, Arrays.asList(temp));
			translations.put(ib, Arrays.asList(ia));
			translations.put(ic, Arrays.asList(ia));
		}

		HashMap<String, String> originalData = new HashMap<>();
		for (int i = 0; i < m; i++) {
			String first = io.getWord();
			String second = io.getWord();
			originalData.put(first, second);
			originalData.put(second, first);
		}

		HashMap<String, List<String>> graph = new HashMap<>();

		for (Entry<String, String> edge : originalData.entrySet()) {

			List<String> list = translations.get(edge.getKey());
			for (String str : list)
				modifyGraph(graph, str, edge.getValue());
		}

		Queue<State> q = new ArrayDeque<>();
		String start = "1A";
		q.add(new State(null, start));
		HashSet<String> visited = new HashSet<>();
		visited.add(start);
		String result = "Impossible";
		while (!q.isEmpty()) {

			State currentState = q.poll();
			List<String> neighbours = graph.get(currentState.vertex);
			if (neighbours != null)
				for (String neighbour : neighbours) {
					if (neighbour.equals(start)) {
						result = toPath(new State(currentState, start), n, originalData);
						q.clear();
						break;
					}
					if (visited.contains(neighbour)) {
						continue;
					}

					visited.add(neighbour);
					q.add(new State(currentState, neighbour));
				}
		}

		io.println(result);
		io.close();
	}

	private static String toPath(State state, int n, HashMap<String, String> originalData) {
		Character[] paths = new Character[n + 1];
		Arrays.fill(paths, 'B');
		State currentState = state;
		while (currentState != null) {

			String prevVertex = originalData.get(currentState.vertex);
			int length = prevVertex.length();
			char last = prevVertex.charAt(length - 1);
			if (last != 'A') {
				int turn = Integer.parseInt(prevVertex.substring(0, length - 1));
				paths[turn] = last;
			}

			currentState = currentState.prev;
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < paths.length; i++) {
			builder.append(paths[i]);
		}
		return builder.toString();
	}

	private static void modifyGraph(HashMap<String, List<String>> graph, String edge, String value) {
		List<String> neighbours = graph.get(edge);
		if (neighbours == null) {
			neighbours = new ArrayList<>();
		}
		neighbours.add(value);
		graph.put(edge, neighbours);
	}

	static class State {

		State prev;
		String vertex;

		public State(State prev, String vertex) {
			super();
			this.prev = prev;
			this.vertex = vertex;
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
