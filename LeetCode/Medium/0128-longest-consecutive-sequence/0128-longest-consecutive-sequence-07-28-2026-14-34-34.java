class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums)
            set.add(num);

        int ans = 0;

        for (int num : set) {

            // Start only if num is the beginning of a sequence
            if (!set.contains(num - 1)) {

                int cur = num;
                int l = 1;

                while (set.contains(cur+1)) {
                    cur++;
                    l++;
                }

                ans= Math.max(ans, l);
            }
        }

        return ans;
    }
}