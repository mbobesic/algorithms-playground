// link: https://open.kattis.com/problems/catvsdog
// name: Cats vs Dogs
package kattis;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by mislav on 11/20/14.
 */
public class CatvsDog {

	public static void main(String[] args) {

		// input the graph
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int t = 0; t < T; t++) {
			solve(input);
		}
		input.close();
	}

	private static void solve(Scanner input) {
		int c = input.nextInt();
		int d = input.nextInt();

		int v = input.nextInt();
		String skip = input.nextLine();

		HashMap<String, Set<Integer>> haters = new HashMap<>();
		HashMap<String, Set<Integer>> lovers = new HashMap<>();

		ArrayList<Set<Integer>> graph = new ArrayList<>();
		Set<Integer> dogLovers= new HashSet<>();
		String[] inputs = new String[v];

		for (int i = 0; i < v; i++) {

			inputs[i] = input.nextLine();
		}

		for (int i = 0; i < v; i++) {

			String[] votes = inputs[i].split(" ");
			if (votes[0].charAt(0) == 'D') {
				dogLovers.add(i);
			}
			putIfAbsent(lovers, votes[0], i);
			putIfAbsent(haters, votes[1], i);
		}

		for (int i = 0; i < v; i++) {

			String[] votes = inputs[i].split(" ");

			Set<Integer> conflicts = new HashSet<>();
			if (haters.get(votes[0]) != null)
				conflicts.addAll(haters.get(votes[0]));
			if (lovers.get(votes[1]) != null)
				conflicts.addAll(lovers.get(votes[1]));
			graph.add(conflicts);
		}
		
		int[] connectedTo = new int[v];
		boolean[] visited = new boolean[v];
		Arrays.fill(connectedTo, -1);
		int minimumCut = 0;
		for (Integer dogLover : dogLovers) {
			Arrays.fill(visited, false);
			minimumCut += DFS(dogLover, graph, visited, connectedTo);
		}
		
		System.out.println(v-minimumCut);
	}
	
	private static int DFS(int x, ArrayList<Set<Integer>> graph, boolean visited[], int connectedTo[]) {

		visited[x] = true;

		for (int who : graph.get(x)) {

			int connect = connectedTo[who];

			if (connect == -1) {
				connectedTo[who] = x;
				return 1;
			}
			if (!visited[connect] && DFS(connect, graph, visited, connectedTo) == 1) {
				connectedTo[who] = x;
				return 1;
			}

		}

		return 0;
	}
	
	private static void putIfAbsent(HashMap<String, Set<Integer>> map, String key, Integer voter) {

		Set<Integer> voters = map.get(key);

		if (voters == null) {
			voters = new TreeSet<>();
		}

		if (voters.contains(voter)) {
			return;
		}
		voters.add(voter);
		map.put(key, voters);
	}
}
