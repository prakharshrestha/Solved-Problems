class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int[] nums2 = new int[n];

        return odd(nums1, nums2, n) || even(nums1, nums2, n);
    }
    public boolean odd(int[] nums1, int[] nums2, int n) {

        int smallestOdd = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums1[i] % 2 != 0) {
                smallestOdd = Math.min(smallestOdd, nums1[i]);
            }
        }
        if (smallestOdd == Integer.MAX_VALUE) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (nums1[i] % 2 == 0) {
                if (nums1[i] <= smallestOdd) {
                    return false;
                }
                nums2[i] = nums1[i] - smallestOdd;
            } else {
                nums2[i] = nums1[i];
            }
        }
        return true;
    }
    public boolean even(int[] nums1, int[] nums2, int n) {

        for (int i = 0; i < n; i++) {
            if (nums1[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}