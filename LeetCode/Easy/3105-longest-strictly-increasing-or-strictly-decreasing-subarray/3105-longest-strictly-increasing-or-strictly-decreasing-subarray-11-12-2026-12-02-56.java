class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int ans2 = 1;
        int len = 1;

        int l = 0;
        int r = 1;

        while (r < n) {
            if (nums[r] > nums[r - 1]) {
                len = r - l + 1;
            } else {
                ans = Math.max(ans, len);
                l = r;
                len = 1;
            }
            r++;
        }
        ans = Math.max(ans, len);
        l = 0;
        r = 1;
        len = 1;

        while (r < n) {
            if (nums[r] < nums[r - 1]) {
                len = r - l + 1;
            } else {
                ans2 = Math.max(ans2, len);
                l = r;
                len = 1;
            }
            r++;
        }
        ans2 = Math.max(ans2, len);
        
        return Math.max(ans, ans2);
    }
}