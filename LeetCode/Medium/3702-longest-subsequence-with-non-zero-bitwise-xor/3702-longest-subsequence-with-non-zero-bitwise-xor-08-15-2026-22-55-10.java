class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXor = 0;

        for (int i = 0; i < nums.length; i++) {
            totalXor = totalXor ^ nums[i];
        }
        if (totalXor != 0) 
        return nums.length;
    
        boolean hasNonZeroElement = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) 
            hasNonZeroElement = true;
        }
        if (hasNonZeroElement == true) 
        return nums.length - 1;
        
        return 0;
    }
}