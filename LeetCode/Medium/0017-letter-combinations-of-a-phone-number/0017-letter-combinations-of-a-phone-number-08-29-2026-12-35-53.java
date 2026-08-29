class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;

        String[] keys = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        solve(ans, digits, keys, 0, "");
        return ans;
    }
    
    public void solve(List<String> ans, String digits, String[] keys, int ind, String str) {
        if (ind == digits.length()) {
            ans.add(str);
            return;
        }
        String letters = keys[digits.charAt(ind) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            solve(ans, digits, keys, ind + 1,
                    str + letters.charAt(i));
        }
    }
}