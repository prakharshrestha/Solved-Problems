class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int s1 = 0;
        int s2 = 0;

        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            if (i < n / 2) {
                if (ch == '?') {
                    left++;
                } else {
                    s1 += ch - '0';
                }
            } else {
                if (ch == '?') {
                    right++;
                } else {
                    s2 += ch - '0';
                }
            }
        }

        if ((left + right) % 2 == 1) {
            return true;
        }

        int sumDiff = s1 - s2;
        int qDiff = (right - left) * 9 / 2;

        if (sumDiff == qDiff) {
            return false; 
        }

        return true;
    }
}