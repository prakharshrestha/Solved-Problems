class Solution {

    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int ans = 0;
        int index=0;
        for (int i = 0; i < n; i++) {

            char x = s.charAt(i);

            if (map.containsKey(x)) {
                index=map.get(x)+1;
                l = Math.max(l,index);
            }

            map.put(x, i);

            ans = Math.max(ans, i - l + 1);
        }

        return ans;
    }
}