class Solution {
    public boolean rotateString(String s, String goal) {

        for (int i = 1; i <= s.length(); i++) {
            String str = rotate(s, i);
            if (str.equals(goal))
                return true;
        }
        return false;
    }
    public String rotate(String s, int i) {

        char[] ans = new char[s.length()];
        i = i % s.length();

        for (int j = 0; j < s.length(); j++) {
            ans[(j + i) % s.length()] = s.charAt(j);
        }
        return String.valueOf(ans);
    }
}