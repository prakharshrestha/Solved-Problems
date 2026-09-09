class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> ans = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            ans.add(nums[i]);
        }
        int i = 0;
        for(int x : ans) {
            nums[i] = x;
            i++;
        }
        return ans.size();
    }
}