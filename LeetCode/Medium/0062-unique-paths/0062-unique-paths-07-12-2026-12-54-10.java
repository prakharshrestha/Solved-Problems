// Tabulation:

class Solution {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        dp[m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                if (i == m - 1 && j == n - 1)
                    continue;

                int down = 0;
                int right = 0;

                if (i + 1 < m)
                    down = dp[i + 1][j];

                if (j + 1 < n)
                    right = dp[i][j + 1];

                dp[i][j] = down + right;
            }
        }

        return dp[0][0];
    }
}

//Memoization:
// class Solution {

//     public int uniquePaths(int m, int n) {

//         int[][] dp = new int[m][n];

//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return solve(0, 0, m, n, dp);
//     }

//     public int solve(int i, int j, int m, int n, int[][] dp) {

//         if (i == m - 1 && j == n - 1)
//             return 1;

//         if (i >= m || j >= n)
//             return 0;

//         if (dp[i][j] != -1)
//             return dp[i][j];

//         int down = solve(i + 1, j, m, n, dp);
//         int right = solve(i, j + 1, m, n, dp);

//         return dp[i][j] = down + right;
//     }
// }