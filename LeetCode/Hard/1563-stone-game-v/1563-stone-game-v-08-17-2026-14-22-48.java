class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }
        int[][] dp = new int[n][n];
        int[][] maxLeft = new int[n][n];
        int[][] maxRight = new int[n][n];
        for (int i = 0; i < n; i++) {
            maxLeft[i][i] = stoneValue[i];
            maxRight[i][i] = stoneValue[i];
        }
        for (int length = 2; length <= n; length++) {
            for (int start = 0; start + length - 1 < n; start++) {
                int end = start + length - 1;
                int low = start;
                int high = end - 1;
                int splitPoint = start - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    int leftSum = prefixSum[mid + 1] - prefixSum[start];
                    int rightSum = prefixSum[end + 1] - prefixSum[mid + 1];
                    if (leftSum <= rightSum) {
                        splitPoint = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                int best = 0;
                if (splitPoint >= start) {
                    best = Math.max(best, maxLeft[start][splitPoint]);

                    int leftSum = prefixSum[splitPoint + 1] - prefixSum[start];
                    int rightSum = prefixSum[end + 1] - prefixSum[splitPoint + 1];
                    if (leftSum == rightSum) {
                        best = Math.max(best, maxRight[splitPoint + 1][end]);
                    }
                }
                if (splitPoint + 2 <= end) {
                    best = Math.max(best, maxRight[splitPoint + 2][end]);
                }
                dp[start][end] = best;
                int totalSum = prefixSum[end + 1] - prefixSum[start];
                maxLeft[start][end] = Math.max(maxLeft[start][end - 1], dp[start][end] + totalSum);
                maxRight[start][end] = Math.max(maxRight[start + 1][end], dp[start][end] + totalSum);
            }
        }

        return dp[0][n - 1];
    }
}