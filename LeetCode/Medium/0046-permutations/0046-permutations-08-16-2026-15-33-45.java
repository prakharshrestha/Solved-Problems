class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        solve(nums, used, new ArrayList<>(), ans);
        return ans;
    }
    public void solve(int[] nums,boolean[] used,List<Integer> temp,List<List<Integer>> ans) {

        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);

            solve(nums, used, temp, ans);

            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}