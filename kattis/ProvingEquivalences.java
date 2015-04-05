// link: https://open.kattis.com/problems/equivalences
// name: Proving Equivalences
package kattis;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class ProvingEquivalences {

	private static Scanner input;

	private static int cnt, scnt;
	private static int[] id, pre, low;
	private static Deque<Integer> stack;
	private static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) {
		input = new Scanner(System.in);

		int testsLeft = input.nextInt();
		while (testsLeft-- > 0) {

			solve();
		}
		input.close();
	}

	private static void solve() {
		cnt = 0;
		scnt = 0;
		int vertexCount = input.nextInt();
		int edgeCount = input.nextInt();

		graph = new ArrayList<>();

		for (int i = 0; i < vertexCount + 1; ++i) {
			ArrayList<Integer> neighbours = new ArrayList<>();
			graph.add(neighbours);
		}

		for (int i = 0; i < edgeCount; ++i) {
			int from = input.nextInt();
			int to = input.nextInt();
			graph.get(from).add(to);
		}

		stack = new ArrayDeque<>();
		id = new int[vertexCount + 1];
		pre = new int[vertexCount + 1];
		low = new int[vertexCount + 1];

		for (int i = 0; i < vertexCount + 1; ++i) {
			id[i] = -1;
			pre[i] = -1;
			low[i] = -1;
		}

		for (int v = vertexCount; v > 0; --v) {
			if (pre[v] == -1)
				strong_components(v);
		}
		
		int[] outDegrees = new int[scnt];
		int[] inDegrees = new int[scnt];

		for (int from = 0; from < vertexCount + 1; ++from) {
			for (Integer to : graph.get(from)) {

				if (id[from] == id[to]) {
					continue;
				}

				++outDegrees[id[from]];
				++inDegrees[id[to]];
			}
		}
		
		if (scnt == 1){
			System.out.println(0);
			return;
		}
		
		int sinks = 0;
		int sources = 0;

		for (int v = scnt - 1; v >= 0; --v) {
			if (outDegrees[v] == 0){
				++sinks;
			}
			
			if (inDegrees[v] == 0){
				++sources;
			}
		}
		int result = sinks > sources ? sinks : sources;

		System.out.println(result);
	}

	private static void strong_components(int w) {

		int t;
		int min = cnt;
		low[w] = cnt;
		pre[w] = cnt;
		++cnt;

		stack.push(w);

		ArrayList<Integer> neighbours = graph.get(w);

		for (Integer neighbour : neighbours) {

			if (pre[neighbour] == -1) {
				strong_components(neighbour);
			}

			if (low[neighbour] < min) {
				min = low[neighbour];
			}
		}

		if (min < low[w]) {
			low[w] = min;
			return;
		}

		while (true) {

			t = stack.pop();

			id[t] = scnt;
			low[t] = graph.size();
			if (t == w) {
				break;
			}
		}
		scnt++;
	}
}
