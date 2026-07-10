import java.util.*;

class Solution {

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];

        solve(0, adj, vis, ans);

        return ans;
    }

    public void solve(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis, ArrayList<Integer> ans) {

        // Mark the node as visited
        vis[node] = true;

        // Store the node in the answer
        ans.add(node);

        // Visit all neighbours
        for (int neighbour : adj.get(node)) {

            if (vis[neighbour] == false) {
                solve(neighbour, adj, vis, ans);
            }

        }
    }
}