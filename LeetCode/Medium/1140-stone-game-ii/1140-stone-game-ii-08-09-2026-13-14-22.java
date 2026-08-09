class Solution {

    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1);
    }

    public int solve(int i, int M) {

        if (i >= n) {
            return 0;
        }

        if (i + 2 * M >= n) {
            return suffix[i];
        }

        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int best = 0;

        for (int X = 1; X <= 2 * M; X++) {

            int newM = Math.max(M, X);

            int taken = suffix[i] - suffix[i + X];

            int opponent = solve(i + X, newM);

            int current = taken + suffix[i + X] - opponent;

            best = Math.max(best, current);
        }

        dp[i][M] = best;

        return best;
    }
}