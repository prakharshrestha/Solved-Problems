// better

class Solution {

    public String longestPalindrome(String s) {

        int n = s.length();

        for (int length = n; length >= 1; length--) {

            for (int l = 0; l + length <= n; l++) {

                int r = l + length - 1;

                if (check(s, l, r)) {
                    return s.substring(l, r + 1);
                }
            }
        }

        return "";
    }

    public boolean check(String s, int l, int r) {

        while (l < r) {

            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}