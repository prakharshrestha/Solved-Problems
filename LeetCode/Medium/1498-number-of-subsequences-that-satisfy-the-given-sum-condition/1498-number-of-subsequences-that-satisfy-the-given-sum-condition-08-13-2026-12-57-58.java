import java.util.*;

class Solution {

    static final int MOD = 1000000007;

    public int numSubseq(int[] nums, int target) {

        Arrays.sort(nums);

        int n = nums.length;
        long[] power = new long[n];
        power[0] = 1;

        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % MOD;
        }

        int left = 0;
        int right = n - 1;
        long ans = 0;

        while (left <= right) {

            if (nums[left] + nums[right] <= target) {

                ans = (ans + power[right - left]) % MOD;

                left++;

            } else {

                right--;
            }
        }

        return (int) ans;
    }
}