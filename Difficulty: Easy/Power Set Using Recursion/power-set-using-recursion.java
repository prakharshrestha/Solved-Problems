class Solution {
    public ArrayList<String> powerSet(String s) {
        ArrayList<String> ans=new ArrayList<>();
        ans.add("");
        solve(s,ans,0,"");
        return ans;
    }
    public void solve(String s,ArrayList<String> ans,int i,String curr){
        if(i==s.length()){
            ans.add(curr);
            return;
        }
        solve(s,ans,i+1,curr+s.charAt(i));
        solve(s,ans,i+1,curr);
    }
}
