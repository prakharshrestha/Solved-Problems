class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(s, t, 0, 0, dp);
    }
    public int solve(String s, String t, int i, int j, int[][] dp) {
        if (j == t.length()) 
        return 1; 

        if (i == s.length()) 
        return 0;
        
        if (dp[i][j] != -1)
        return dp[i][j];
        
        int c = 0;
        if (s.charAt(i) == t.charAt(j)) {
            c += solve(s, t, i + 1, j + 1, dp);
        }
        c+= solve(s, t, i + 1, j, dp);
        dp[i][j] = c;
        return c;
    }
}