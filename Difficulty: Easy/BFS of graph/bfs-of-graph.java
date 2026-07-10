import java.util.*;

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];

        Queue<Integer> q = new LinkedList<>();

        // Start from node 0
        q.offer(0);
        vis[0] = true;

        while (!q.isEmpty()) {

            int node = q.poll();

            ans.add(node);

            // Visit all neighbours
            for (int neighbour : adj.get(node)) {

                if (!vis[neighbour]) {

                    vis[neighbour] = true;
                    q.offer(neighbour);

                }
            }
        }

        return ans;
    }
}