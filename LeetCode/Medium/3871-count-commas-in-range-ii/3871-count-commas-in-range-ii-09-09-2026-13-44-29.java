class Solution {
    public long countCommas(long n) {
        long count = 0;
        long start = 1000;
        long end = 999999;
        long commas = 1;
        while (start <= n) {
            long last = Math.min(n, end);
            count += (last - start + 1) * commas;

            start = end + 1;
            end = end * 1000 + 999;
            commas++;
        }
        return count;
    }
}