class Solution {
	public static int countSubstring(String s) {
		int[] last = {-1, -1, -1};
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == 'a')
				last[0] = i;
			else if (ch == 'b')
				last[1] = i;
			else
				last[2] = i;
			int min = Math.min(last[0], Math.min(last[1], last[2]));
			if (min != -1)
				ans += min + 1;
		}
		return ans;
	}
}
