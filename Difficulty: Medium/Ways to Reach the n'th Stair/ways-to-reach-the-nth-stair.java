class Solution {
    public int countWays(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve2(n,0,dp);
        
    }
    // public int solve(int n,int ans){
    //     if(n==0)
    //     return 1;
        
    //     if(n<0)
    //     return 0;
        
    //     return solve(n-1,ans+1)+solve(n-2,ans+1);

    // }
    
    public int solve2(int n,int ans,int[] dp){
        if(n==0)
        return 1;
        
        if(n<0)
        return 0;
        
        if(dp[n]!=-1)
        return dp[n];
        
        return dp[n]=solve2(n-1,ans+1,dp)+solve2(n-2,ans+1,dp);
    }
}