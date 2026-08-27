class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        solve(ans,"",0,0,n);
        return ans;
    }
    public void solve(List<String> ans,String s,int o,int c,int n){
        if(o==n&&c==n){
            ans.add(s);
            return;
        }
        if(o<n)
        solve(ans,s+"(",o+1,c,n);

        if(c<o)
        solve(ans,s+")",o,c+1,n);
    }
}