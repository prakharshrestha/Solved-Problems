class Solution {

    public int solve(int[] stones, int index, int[] dp){

        if(index >= stones.length)
            return 0;

        int best = Integer.MIN_VALUE;

        int sum = 0;

        if(dp[index]!=0)
        return dp[index];

        for(int i = index; i < Math.min(index + 3, stones.length); i++){

            sum += stones[i];

            best = Math.max(best,
                    sum - solve(stones, i + 1,dp));
            
        }

        dp[index]=best;
        return dp[index];
    }

    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        int[] dp=new int[n];

        int ans = solve(stoneValue,0,dp);
        
        if(ans > 0)
            return "Alice";

        if(ans < 0)
            return "Bob";

        return "Tie";
    }
}