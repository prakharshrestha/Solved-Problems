import java.util.*;

class Solution {

    public int[] dijkstra(int V, int[][] edges, int src) {

        // Step 1: Create adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Build graph
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            // Undirected Graph
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        // Step 3: Distance array
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        // Step 4: Min Heap
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // {node, distance}
        pq.add(new int[]{src, 0});

        // Step 5: Dijkstra
        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int node = curr[0];
            int d = curr[1];

            // Visit all neighbours
            for (int[] neighbour : adj.get(node)) {

                int next = neighbour[0];
                int weight = neighbour[1];

                if (d + weight < dist[next]) {

                    dist[next] = d + weight;

                    pq.add(new int[]{next, dist[next]});
                }
            }
        }

        return dist;
    }
}