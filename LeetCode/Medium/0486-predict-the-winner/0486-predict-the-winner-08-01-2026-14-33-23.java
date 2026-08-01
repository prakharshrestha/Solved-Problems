class Solution {
    public boolean predictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length - 1, 0, 0, true);
    }
    public boolean solve(int[] nums,int left,int right,int p1,int p2, boolean TurnP1) {

        if (left > right)
            return p1 >= p2;

        if (TurnP1) {

            boolean chooseLeft = solve(nums, left + 1, right, p1 + nums[left], p2, false);

            boolean chooseRight = solve(nums, left, right - 1, p1 + nums[right], p2, false);

            return chooseLeft || chooseRight;

        } else {

            boolean chooseLeft = solve(nums, left + 1, right, p1, p2 + nums[left], true);

            boolean chooseRight = solve(nums, left, right - 1, p1, p2 + nums[right], true);

            return chooseLeft && chooseRight;
        }
    }
    
}