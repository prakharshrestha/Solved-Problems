class Solution {

    Integer[][] dp;

    public int solve(int[] nums, int left, int right){

        if(left == right)
            return nums[left];

        if(dp[left][right] != null)
            return dp[left][right];

        int chooseLeft =
            nums[left] - solve(nums, left + 1, right);

        int chooseRight =
            nums[right] - solve(nums, left, right - 1);

        dp[left][right] = Math.max(chooseLeft, chooseRight);

        return dp[left][right];
    }
    public boolean stoneGame(int[] piles) {
        dp = new Integer[piles.length][piles.length];
        return solve(piles,0,piles.length-1) >= 0;
    }

}

