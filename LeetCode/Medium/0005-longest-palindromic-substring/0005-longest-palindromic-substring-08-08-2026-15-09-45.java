class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        String ans="";
        for(int l=0;l<n;l++){
            for(int r=l;r<n;r++){
                if(check(s,l,r)){
                    if(r-l+1>ans.length())
                    ans=s.substring(l,r+1);
                }
            }
        }
        return ans;
    }
    public boolean check(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
            return false;

            l++;
            r--;
        }
        return true;
    }
}