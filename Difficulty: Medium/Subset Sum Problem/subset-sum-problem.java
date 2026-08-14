class Solution {

    static Boolean[][] dp;

    static boolean isSubsetSum(int arr[], int sum) {

        dp = new Boolean[arr.length][sum + 1];

        return solve(arr, sum, 0, 0);
    }

    static boolean solve(int[] arr, int sum, int i, int curr) {

        if (curr == sum)
            return true;

        if (curr > sum || i == arr.length)
            return false;

        if (dp[i][curr] != null)
            return dp[i][curr];

        boolean take = solve(arr, sum, i + 1, curr + arr[i]);

        boolean notTake = solve(arr, sum, i + 1, curr);

        return dp[i][curr] = take || notTake;
    }
}