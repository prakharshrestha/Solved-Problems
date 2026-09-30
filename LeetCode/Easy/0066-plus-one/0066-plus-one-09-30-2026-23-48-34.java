class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length;
        if(digits[n - 1] != 9) {
            digits[n - 1]++;
            return digits;
        }
        int l = n - 1;
        while(l >= 0 && digits[l] == 9) {
            digits[l] = 0;
            l--;
        }
        if(l < 0) {
            int[] ans = new int[n + 1];
            ans[0] = 1;
            return ans;
        }
        digits[l]++;
        return digits;
    }
}