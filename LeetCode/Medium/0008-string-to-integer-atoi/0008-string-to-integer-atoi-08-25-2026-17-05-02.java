class Solution {

    public int myAtoi(String s) {

        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        boolean negative = false;

        if (i < s.length()) {
            if (s.charAt(i) == '-') {
                negative = true;
                i++;
            }
            else if (s.charAt(i) == '+') {
                i++;
            }
        }

        return solve(s, i, 0, negative);
    }

    private int solve(String s, int i, long ans, boolean negative) {

        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {

            if (negative) {
                ans = -ans;
            }

            if (ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            return (int) ans;
        }

        int digit = s.charAt(i) - '0';

        if (ans > (Integer.MAX_VALUE - digit) / 10) {
            if (negative) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }

        ans = ans * 10 + digit;

        return solve(s, i + 1, ans, negative);
    }
}