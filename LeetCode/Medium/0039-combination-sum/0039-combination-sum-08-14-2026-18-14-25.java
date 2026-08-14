class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    public void solve(int[] cand, int t, int i,List<List<Integer>> ans,List<Integer> temp) {

        if (t == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (i == cand.length || t < 0) {
            return;
        }

        temp.add(cand[i]);

        solve(cand, t - cand[i], i, ans, temp);

        temp.remove(temp.size() - 1);

        solve(cand, t, i + 1, ans, temp);
    }
}