class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int ans = 0;

        String str = "";

        for (int i = 0; i < n; i++) {

            char x = s.charAt(i);

            if (str.indexOf(x) == -1) {

                str = str + x;

            } else {

                str = str.substring(str.indexOf(x) + 1);

                str = str + x;
            }

            ans = Math.max(ans, str.length());
        }

        return ans;
    }
}