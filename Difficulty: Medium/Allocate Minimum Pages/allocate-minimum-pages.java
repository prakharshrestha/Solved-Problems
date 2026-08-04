class Solution {
    public int findPages(int[] arr, int k) {

        int n = arr.length;

        if (k > n)
            return -1;

        long l = 0, r = 0;

        for (int x : arr) {
            l = Math.max(l, x);
            r += x;
        }

        long ans = -1;

        while (l <= r) {

            long mid = l + (r - l) / 2;

            if (solve(arr, k, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return (int) ans;
    }

    public boolean solve(int[] arr, int k, long mid) {

        long pages = 0;
        int students = 1;

        for (int x : arr) {

            if (pages + x <= mid) {
                pages += x;
            } else {
                students++;
                pages = x;

                if (students > k)
                    return false;
            }
        }

        return true;
    }
}