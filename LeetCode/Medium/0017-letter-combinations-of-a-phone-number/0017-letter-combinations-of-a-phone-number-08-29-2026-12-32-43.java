class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) return ans;

        HashMap<Integer, String> keys = new HashMap<>();

        keys.put(2, "abc");
        keys.put(3, "def");
        keys.put(4, "ghi");
        keys.put(5, "jkl");
        keys.put(6, "mno");
        keys.put(7, "pqrs");
        keys.put(8, "tuv");
        keys.put(9, "wxyz");

        solve(ans, digits, keys, 0, "");
        return ans;
    }
    public void solve(List<String> ans, String digits,HashMap<Integer, String> keys,int ind, String str) {

        if (ind == digits.length()) {
            ans.add(str);
            return;
        }
        int d = digits.charAt(ind) - '0';
        String letters = keys.get(d);
        for (int i = 0; i < letters.length(); i++) {
            solve(ans, digits, keys, ind + 1,str + letters.charAt(i));
        }
    }
}