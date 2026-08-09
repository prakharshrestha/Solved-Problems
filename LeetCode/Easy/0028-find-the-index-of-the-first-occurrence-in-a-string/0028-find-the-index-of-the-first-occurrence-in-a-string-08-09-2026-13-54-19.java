class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int l=0;

        for(int i=0;i<n;i++){
            if(needle.length()==(i-l+1)){
                if(haystack.substring(l,i+1).equals(needle))
                return l;
                else
                l++;
            }
        }
        return -1;
    }
}