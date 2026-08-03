class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target)
                return mid;

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                // Target lies inside left half
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                }
                // Target is in right half
                else {
                    left = mid + 1;
                }
            }

            // Right half is sorted
            else {

                // Target lies inside right half
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }
                // Target is in left half
                else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}