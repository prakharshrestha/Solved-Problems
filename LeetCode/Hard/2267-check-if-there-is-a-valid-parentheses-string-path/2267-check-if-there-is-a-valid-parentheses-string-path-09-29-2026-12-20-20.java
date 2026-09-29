class Solution {

    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if((m + n - 1) % 2 != 0)
            return false;

        dp = new Boolean[m][n][m + n];
        return solve(grid, 0, 0, 0);
    }

    public boolean solve(char[][] grid, int i, int j, int c) {

        if(grid[i][j] == '(')
            c++;
        else
            c--;

        if(c < 0)
            return false;

        if(i == grid.length - 1 &&j == grid[0].length - 1) {
            return c == 0;
        }

        if(dp[i][j][c] != null)
            return dp[i][j][c];

        boolean down = false;
        boolean right = false;

        if(i + 1 < grid.length)
            down = solve(grid, i + 1, j, c);

        if(j + 1 < grid[0].length)
            right = solve(grid, i, j + 1, c);

        return dp[i][j][c] = down || right;
    }
}