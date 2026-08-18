class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (k == n) {
            int max = nums[0];

            for (int num : nums) {
                max = Math.max(max, num);
            }

            return max;
        }
        if (k == 1) {
            int max = -1;

            for (int num : nums) {
                if (map.get(num) == 1) {
                    max = Math.max(max, num);
                }
            }
            return max;
        }
        int first = -1;
        int last = -1;
        if (map.get(nums[0]) == 1) {
            first = nums[0];
        }
        if (map.get(nums[n - 1]) == 1) {
            last = nums[n - 1];
        }
        return Math.max(first, last);
    }
}