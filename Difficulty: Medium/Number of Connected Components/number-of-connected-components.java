import java.util.*;

class Solution {

    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> e : edges) {

            int u = e.get(0);
            int v = e.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);   
        }

        boolean[] vis = new boolean[V];

        int count = 0;

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {
                dfs(i, adj, vis);
                count++;
            }

        }

        return count;
    }

    public void dfs(int node,
                    ArrayList<ArrayList<Integer>> adj,
                    boolean[] vis) {

        vis[node] = true;

        for (int neighbour : adj.get(node)) {

            if (!vis[neighbour]) {
                dfs(neighbour, adj, vis);
            }

        }
    }
}