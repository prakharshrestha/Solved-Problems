class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int K = 1024;

        boolean[][] dp = new boolean[n][K];
        dp[0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                boolean[] above = dp[j];
                boolean[] curr = new boolean[K];
                if (i > 0) {
                    for (int x = 0; x < K; x++) {
                        if (above[x]) {
                            curr[x ^ grid[i][j]] = true;
                        }
                    }
                }
                if (j > 0) {
                    for (int x = 0; x < K; x++) {
                        if (dp[j - 1][x]) {
                            curr[x ^ grid[i][j]] = true;
                        }
                    }
                }
                dp[j] = curr;
            }
        }
        for (int x = 0; x < K; x++) {
            if (dp[n - 1][x]) {
                return x;
            }
        }
        return -1;
    }
}