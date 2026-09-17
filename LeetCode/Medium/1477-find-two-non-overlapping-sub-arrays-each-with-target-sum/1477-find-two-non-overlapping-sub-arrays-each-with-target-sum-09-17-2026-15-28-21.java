class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left++];
            }
            dp[right + 1] = dp[right];
            if (sum == target) {
                int len = right - left + 1;
                if (dp[left] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + dp[left]);
                }
                dp[right + 1] = Math.min(dp[right + 1], len);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}