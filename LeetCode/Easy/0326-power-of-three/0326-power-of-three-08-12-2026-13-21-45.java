class Solution {
    public boolean isPowerOfThree(int n) {
         if(n <= 0)
            return false;

        if(n == 1)
            return true;

        return solve(n, 3);
    }
    public boolean solve(int n, long p) {

        if(p > n)
            return false;

        if(p == n)
            return true;

        return solve(n, p * 3);
    }
    
}