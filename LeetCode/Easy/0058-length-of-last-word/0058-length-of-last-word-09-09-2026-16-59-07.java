class Solution {
    public int lengthOfLastWord(String s) {
        String str = s.trim();
        String r = "";
        int ans = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch != ' ')
                r = r + ch;
            else {
                ans = r.length();
                break;
            }
        }
        if (ans == 0)
            ans = r.length();

        return ans;
    }
}