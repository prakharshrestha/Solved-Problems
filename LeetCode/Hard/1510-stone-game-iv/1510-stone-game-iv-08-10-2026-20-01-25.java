class Solution {
    public boolean winnerSquareGame(int n) {

        boolean[] dp=new boolean[n + 1];
        
        for (int i=1;i<=n;i++) {

            //every square number
            for (int j=1;j*j<=i;j++) {

                int square=j*j;
                //opponent is in a losing position, current player wins.
                if (dp[i-square]==false) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}