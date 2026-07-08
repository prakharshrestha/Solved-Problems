class Solution {
    public List<String> generateParenthesis(int n) {
        return solve(0, 0, "", n);
    }

    public List<String> solve(int o, int c, String curr, int n) {

        List<String> r = new ArrayList<>();

        if (o == n && c == n) {
            r.add(curr);
            return r;
        }

        if (o < n) {
            r.addAll(solve(o + 1, c, curr + "(", n));
        }

        if (c < o) {
            r.addAll(solve(o, c + 1, curr + ")", n));
        }

        return r;
    }
}