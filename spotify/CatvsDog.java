package spotify;

import java.util.*;

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


        String[] inputs = new String[v];


        for (int i = 0; i < v; i++) {

            inputs[i] = input.nextLine();
        }

        Arrays.sort(inputs);

        int currentDogLover = 0;
        for (int i = 0; i < v; i++) {

            String[] votes = inputs[i].split(" ");

            if (votes[0].charAt(0) == 'C') {
                putIfAbsent(lovers, votes[0], i);
                putIfAbsent(haters, votes[1], i);
            }

            if (votes[0].charAt(0) == 'D') {

                Set<Integer> conflicts = new TreeSet<>();
                conflicts.addAll(haters.get(votes[0]));
                conflicts.addAll(lovers.get(votes[1]));
                graph.add(conflicts);
                currentDogLover++;
            }
        }

        int[] connectedTo = new int[v];
        Arrays.fill(connectedTo, -1);
        int minimumCut = 0;
        boolean[] visited = new boolean[v];


        for (int i = 0; i < currentDogLover; i++) {

            Arrays.fill(visited, false);
            minimumCut += DFS(i, graph, visited, connectedTo);
        }

        System.out.println(v - minimumCut);
    }

    private static int DFS(int x, ArrayList<Set<Integer>> graph, boolean visited[], int connectedTo[]) {

        visited[x] = true;

        for (int who : graph.get(x)) {

            int connect = connectedTo[who];

            if (connect == -1) {
                connectedTo[who] = x;
                return 1;
            }
            if (visited[connect] && DFS(connect, graph, visited, connectedTo) == 0) {
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
