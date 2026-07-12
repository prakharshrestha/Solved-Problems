class Solution {
    public int findMaxSum(int arr[]) {
       int[] dp=new int[arr.length];
       Arrays.fill(dp,-1);
    
       int ans=solve(arr.length-1,arr,dp);
       return ans;
    }
    // public int solve(int i,int[] arr){
        
    //     if(i<0)
    //     return 0;
        
    //     if(i==0)
    //     return arr[0];
        
    //     int pick=arr[i]+solve(i-2,arr);
    //     int notpick=0+solve(i-1,arr);
        
    //     return Math.max(pick,notpick);
    // }
    
    public int solve(int i,int[] arr,int[] dp){
        if(i<0)
        return 0;
        
        if(i==0)
        return arr[i];
        
        if(dp[i]!=-1)
        return dp[i];
        
         int pick=arr[i]+solve(i-2,arr,dp);
         int notpick=0+solve(i-1,arr,dp);
        
         return dp[i]=Math.max(pick,notpick);
        
    }
}