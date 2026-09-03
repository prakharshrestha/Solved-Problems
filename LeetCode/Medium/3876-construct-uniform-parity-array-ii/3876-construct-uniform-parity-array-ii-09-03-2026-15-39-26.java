class Solution {
    public boolean uniformArray(int[] nums) {

        int a = Integer.MAX_VALUE;
        for (int num : nums) {
            a = Math.min(a, num);
        }
        if (a % 2 == 1) {
            return true;
        }
        for (int num : nums) {
            if (num % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}