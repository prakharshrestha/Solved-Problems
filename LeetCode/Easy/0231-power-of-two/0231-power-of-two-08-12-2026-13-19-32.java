class Solution {
    public boolean isPowerOfTwo(int n) {

        if(n<=0)
            return false;
        if(n==1)
            return true;
        return solve(n,2);
    }

    public boolean solve(int n,long p) {

        if(p>n)
            return false;

        if(p==n)
            return true;

        return solve(n,p*2);
    }
}