class Solution {
    public int lengthOfLastWord(String s) {
        String str=s.trim();
        str=str+" ";
        String r="";
        int ans=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch!=' ')
            r=r+ch;
            else{
                ans=r.length();
                r="";
            }
        }
        return ans;
    }
}