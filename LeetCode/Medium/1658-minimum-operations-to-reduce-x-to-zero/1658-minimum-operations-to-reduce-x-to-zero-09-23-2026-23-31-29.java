class Solution {
    public int minOperations(int[] nums, int x) {

        int t = 0;
        for(int num : nums) {
            t += num;
        }
        int target = t - x;
        if(target < 0)
            return -1;

        int l = 0;
        int sum = 0;
        int maxLen = -1;

        for(int r = 0; r < nums.length; r++) {

            sum += nums[r];
            while(sum > target && l <= r) {
                sum -= nums[l];
                l++;
            }
            if(sum == target) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }
        if(maxLen == -1)
            return -1;

        return nums.length - maxLen;
    }
}