import java.util.*;

class Solution {
    public List<String> powerSet(String s) {

        List<String> ans=new ArrayList<>();

        solve(ans,s,0,"");
        Collections.sort(ans);
        return ans;
    }

    public void solve(List<String> ans, String s, int i, String curr) {

        if (i == s.length()) {
            ans.add(curr);
            return;
        }
        // Take current character
        solve(ans,s,i+1,curr+s.charAt(i));

        // Don't take current character
        solve(ans,s,i+1,curr);
    }
}