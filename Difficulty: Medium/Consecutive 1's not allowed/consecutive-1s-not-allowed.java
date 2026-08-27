class Solution {
	
	int countStrings(int n) {
		int[][] dp = new int[n + 1][2];
		
		for (int i = 0; i <= n; i++) {
			dp[i][0] = -1;
			dp[i][1] = -1;
		}
		return solve(n, 0, 0, dp);
	}
	public int solve(int n, int i, int flag, int[][] dp) {
		
		if (i == n) {
			return 1;
		}
		if (dp[i][flag] != -1) {
			return dp[i][flag];
		}
		if (flag == 1) {
			return dp[i][flag] = solve(n, i + 1, 0, dp);
		}
		return dp[i][flag] = solve(n, i + 1, 0, dp) + solve(n, i + 1, 1, dp);
	}
}
