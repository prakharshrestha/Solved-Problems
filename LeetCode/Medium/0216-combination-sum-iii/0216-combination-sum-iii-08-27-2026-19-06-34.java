class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans, new ArrayList<>(), k, n, 1);
        return ans;
    }
    public void solve(List<List<Integer>> ans, List<Integer> temp,int k, int n, int start) {

        if (temp.size() == k) {
            if (n == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {

            if (i > n) {
                break;
            }
            temp.add(i);
            solve(ans, temp, k, n - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}