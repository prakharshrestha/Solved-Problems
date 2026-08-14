class Solution {
    public boolean isPossible(int[] arr, int s, int x) {

        if (x == 0) {
            return true;
        }

        int n = arr.length;

        long[] paper = new long[n + 1];

        paper[0] = s;

        long sum = 0;

        for (int i = 1; i <= n; i++) {

            sum += paper[i - 1];
            paper[i] = sum + arr[i - 1];
        }
        for (int i = n; i >= 0; i--) {

            if (paper[i] <= x) {
                x -= paper[i];
            }
            if (x == 0) {
                return true;
            }
        }

        return false;
    }
}