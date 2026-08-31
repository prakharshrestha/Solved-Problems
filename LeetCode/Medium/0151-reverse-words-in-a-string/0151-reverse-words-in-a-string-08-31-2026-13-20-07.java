class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        s=s+' ';
        String r="";
        String ans="";
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if(x!=' ')
            r=r+x;
            if(x==' '&& !r.isEmpty()){
                ans=' '+r+ans;
                r="";
            }
        }
        return ans.trim();
    }
}