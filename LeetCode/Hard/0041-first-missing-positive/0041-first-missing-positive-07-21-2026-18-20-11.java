import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            if (nums[0] == 1)
                return 2;
            else
                return 1;
        }

        int[] ans = new int[n + 1];   

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] <= n) {   
                ans[nums[i]] = nums[i];
            }
        }

        for (int i = 1; i <= n; i++) {         
            if (ans[i] == 0)
                return i;
        }

        return n + 1;                           
    }
}