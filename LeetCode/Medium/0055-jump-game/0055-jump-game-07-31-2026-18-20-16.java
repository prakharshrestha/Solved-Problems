class Solution {
    public boolean canJump(int[] nums) {

        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            // current index is not reachable,so we cannot move further.
            if (farthest < i) 
            return false;
            
            farthest = Math.max(farthest, i + nums[i]);

            if (farthest >= nums.length - 1) 
                return true;
            
        }
        return true;
    }
}