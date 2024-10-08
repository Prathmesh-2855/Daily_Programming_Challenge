import java.util.*;

public class Challenge_27 {

    // Function to detect cycle in an undirected graph
    public static boolean hasCycle(int V, List<int[]> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Create the adjacency list for the undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Array to keep track of visited nodes
        boolean[] visited = new boolean[V];

        // Call DFS for each component of the graph
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // If a cycle is detected in any component, return true
                if (dfs(i, -1, visited, graph)) {
                    return true;
                }
            }
        }

        // If no cycle was found, return false
        return false;
    }

    // Helper function to perform DFS and detect a cycle
    private static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;

        // Traverse the neighbors of the current node
        for (int neighbor : graph.get(node)) {
            // If the neighbor is not visited, call dfs recursively
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, graph)) {
                    return true;
                }
            }
            // If the neighbor is visited and is not the parent, a cycle is detected
            else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test case 1
        int V1 = 5;
        List<int[]> edges1 = Arrays.asList(new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{3, 4}, new int[]{4, 1});
        System.out.println("Does the graph have a cycle? " + hasCycle(V1, edges1));  // Output: true

        // Test case 2
        int V2 = 3;
        List<int[]> edges2 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2});
        System.out.println("Does the graph have a cycle? " + hasCycle(V2, edges2));  // Output: false

        // Test case 3
        int V3 = 4;
        List<int[]> edges3 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 0});
        System.out.println("Does the graph have a cycle? " + hasCycle(V3, edges3));  // Output: true
    }
}
