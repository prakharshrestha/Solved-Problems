// Optimal

class Solution {

    public String longestPalindrome(String s) {

        int n = s.length();

        if (n == 1)
            return s;

        String answer = "";

        for (int i = 0; i < n; i++) {

            String odd = expand(s, i, i);

            if (odd.length() > answer.length()) {
                answer = odd;
            }

            String even = expand(s, i, i + 1);

            if (even.length() > answer.length()) {
                answer = even;
            }
        }

        return answer;
    }

    public String expand(String s, int left, int right) {

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}