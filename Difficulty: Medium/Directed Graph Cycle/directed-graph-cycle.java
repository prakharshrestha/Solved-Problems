import java.util.*;

class Solution {

    public boolean isCyclic(int V, int[][] edges) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Create indegree array
        int[] indegree = new int[V];

        // Build graph and indegree array
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        // Queue for nodes having indegree 0
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Count processed vertices
        int count = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            count++;

            // Visit all neighbours
            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        // If all vertices are processed,
        // graph has no cycle.
        if (count == V)
            return false;

        // Otherwise cycle exists.
        return true;
    }
}