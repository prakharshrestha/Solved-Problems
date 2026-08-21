class Solution {

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long minCoin = Integer.MAX_VALUE;

        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        long high = minCoin * k;

        while (low < high) {

            long mid = low + (high - low) / 2;

            long count = countNumbers(mid, coins);

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long countNumbers(long x, int[] coins) {

        int n = coins.length;
        long count = 0;

        // Go through every non-empty subset
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int selected = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    selected++;

                    lcm = findLCM(lcm, coins[i]);

                    // If LCM is greater than x,
                    // this subset contributes 0
                    if (lcm > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            long multiples = x / lcm;

            if (selected % 2 == 1) {
                count += multiples;
            } else {
                count -= multiples;
            }
        }

        return count;
    }

    private long findLCM(long a, long b) {

        return (a / gcd(a, b)) * b;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}