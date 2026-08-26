class Solution {

    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {

        long odd = (n + 1) / 2;
        long even = n / 2;

        long ans = (power(5, odd) * power(4, even)) % MOD;

        return (int) ans;
    }

    private long power(long base, long exp) {

        long result = 1;

        while (exp > 0) {

            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;

            exp = exp / 2;
        }

        return result;
    }
}