import java.util.*;

public class Main {

    static boolean hasRoute(
            ArrayList<ArrayList<Integer>> graph,
            int source,
            int destination) {

        boolean[] visited = new boolean[graph.size()];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == destination) {
                return true;
            }

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Store roads
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Source and destination
        int source = sc.nextInt();
        int destination = sc.nextInt();

        if (hasRoute(graph, source, destination)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
