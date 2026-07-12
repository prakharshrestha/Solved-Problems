class Solution {
    public int nthFibonacci(int n) {
        int ans=solve(n);
        return ans;
    }
    public int solve(int n){
        if(n==0)
        return 0;
        if(n==1)
        return 1;
        int res=solve(n-1)+solve(n-2);
        return res;
    }
}



// class Solution {
//     public int nthFibonacci(int n) {
//         int[] dp=new int[n+1];
//         Arrays.fill(dp,-1);
//         return solve(n,dp);
// }
// public int solve(int n,int[] dp){
//     if(n==0)
//     return 0;
//     if(n==1)
//     return 1;
    
//     if(dp[n]!=-1)
//     return dp[n];
    
//     dp[n]=solve(n-1,dp)+solve(n-2,dp);
//     return dp[n];
// }
// }