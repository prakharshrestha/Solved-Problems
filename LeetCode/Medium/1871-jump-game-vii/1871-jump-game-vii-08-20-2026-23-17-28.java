class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int count = 0;

        for (int i = 1; i < n; i++) {

            int addIndex = i - minJump;

            if (addIndex >= 0 && dp[addIndex]) {
                count++;
            }

            int removeIndex = i - maxJump - 1;

            if (removeIndex >= 0 && dp[removeIndex]) {
                count--;
            }

            if (s.charAt(i) == '0' && count > 0) {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}