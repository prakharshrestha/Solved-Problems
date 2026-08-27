class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    public void solve(List<List<Integer>> ans, List<Integer> temp, int[] nums, int ind) {

        ans.add(new ArrayList<>(temp));
        for (int i = ind; i < nums.length; i++) {

            if (i > ind && nums[i] == nums[i - 1])
                continue;

            temp.add(nums[i]);
            solve(ans, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}