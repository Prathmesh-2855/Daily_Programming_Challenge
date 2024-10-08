import java.util.*;

public class Challenge_26 {

    // Function to find the shortest path in an unweighted graph using BFS
    public static int shortestPath(int V, List<int[]> edges, int start, int end) {
        // Create an adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the adjacency list with edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);  // Since the graph is undirected
        }

        // BFS to find the shortest path
        return bfs(graph, start, end, V);
    }

    // Helper function to perform BFS and return the shortest path length
    private static int bfs(List<List<Integer>> graph, int start, int end, int V) {
        // Edge case: if start and end are the same
        if (start == end) {
            return 0;
        }

        boolean[] visited = new boolean[V];
        Queue<int[]> queue = new LinkedList<>();  // Queue for BFS, storing (node, distance)
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];

            // Visit all adjacent nodes
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    // If we reach the end, return the distance
                    if (neighbor == end) {
                        return distance + 1;
                    }
                    queue.offer(new int[]{neighbor, distance + 1});
                    visited[neighbor] = true;
                }
            }
        }

        // If we exit the loop without finding the end, return -1 (no path found)
        return -1;
    }

    public static void main(String[] args) {
        // Test Case 1
        int V1 = 5;
        List<int[]> edges1 = Arrays.asList(new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{2, 3}, new int[]{3, 4});
        int start1 = 0, end1 = 4;
        System.out.println("Shortest path length: " + shortestPath(V1, edges1, start1, end1));  // Output: 3

        // Test Case 2
        int V2 = 3;
        List<int[]> edges2 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2});
        int start2 = 0, end2 = 2;
        System.out.println("Shortest path length: " + shortestPath(V2, edges2, start2, end2));  // Output: 2

        // Test Case 3
        int V3 = 4;
        List<int[]> edges3 = Arrays.asList(new int[]{0, 1}, new int[]{1, 2});
        int start3 = 2, end3 = 3;
        System.out.println("Shortest path length: " + shortestPath(V3, edges3, start3, end3));  // Output: -1
    }
}
