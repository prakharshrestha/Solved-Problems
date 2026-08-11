class Solution {
    public int missingInteger(int[] nums) {

        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } 
            else {
                break;
            }
        }

        while (true) {

            int count = 0;

            for (int num : nums) {
                if (num == sum) {
                    count++;
                }
            }

            if (count == 0) {
                return sum;
            }

            sum++;
        }
    }
}