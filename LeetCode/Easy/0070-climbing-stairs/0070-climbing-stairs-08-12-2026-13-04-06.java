class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        return solve(n,1,dp);

    }
    public int solve(int n,int i,int[] dp){
        if(i>=n)
        return 1;
        
        if(dp[i]!=0)
        return dp[i];
        dp[i]= solve(n,i+1,dp)+solve(n,i+2,dp);

        return dp[i];
    }
}