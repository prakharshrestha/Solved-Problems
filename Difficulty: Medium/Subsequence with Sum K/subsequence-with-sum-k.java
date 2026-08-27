class Solution {
	public boolean checkSubsequenceSum(int[] arr, int k) {
		Boolean[][] dp = new Boolean[arr.length][k + 1];
		return solve(arr, 0, 0, k, dp);
	}
	public boolean solve(int[] arr, int i, int sum, int k, Boolean[][] dp) {
		if (sum == k) {
			return true;
		}
		if (i == arr.length || sum > k) {
			return false;
		}
		if (dp[i][sum] != null) {
			return dp[i][sum];
		}
		
		boolean take = solve(arr, i + 1, sum + arr[i], k, dp);
		boolean nottake = solve(arr, i + 1, sum, k, dp);
		
		dp[i][sum] = take || nottake;
		return dp[i][sum];
	}
}
