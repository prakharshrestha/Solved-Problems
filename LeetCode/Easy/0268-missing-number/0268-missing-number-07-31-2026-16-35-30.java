class Solution {
    public int missingNumber(int[] nums) {
        //Optimal O(n)
        int  n=nums.length;
        int sum = (n * (n + 1)) / 2;
        int actual = 0;

        for (int num : nums) {
            actual += num;
        }

        return sum - actual;

    }
}