class Solution {
    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;

        int ans = 0;

        while (l < r) {

            int width = r - l;
            int h = Math.min(height[l], height[r]);

            ans = Math.max(ans, width * h);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }
}