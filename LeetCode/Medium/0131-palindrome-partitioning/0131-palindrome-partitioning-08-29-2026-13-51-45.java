class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        solve(ans,new ArrayList<>(),s,0);
        return ans;
    }
    public void solve(List<List<String>> ans,List<String> temp,String s,int ind){
        if(ind==s.length())
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(isPalindrome(ind,i,s)){
                temp.add(s.substring(ind,i+1));
                solve(ans,temp,s,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrome(int l,int r,String s){
        while(l<r){
           if(s.charAt(l)!=s.charAt(r)){
            return false;
           }
           l++;
           r--;
        }
        return true;
    }
}