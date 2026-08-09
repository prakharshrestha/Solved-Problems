//Two Pointer
class Solution {

    public int strStr(String haystack, String needle) {

        int n= haystack.length();
        int m= needle.length();

        int left= 0;
        int right= 0;
        while (right<n) {
            if (right-left+1 == m) {
                int j = 0;
                while (j<m && haystack.charAt(left + j) == needle.charAt(j)) {
                    j++;
                }
                if (j == m) {
                    return left;
                }
                left++;
            }
            right++;
        }
        return -1;
    }
}