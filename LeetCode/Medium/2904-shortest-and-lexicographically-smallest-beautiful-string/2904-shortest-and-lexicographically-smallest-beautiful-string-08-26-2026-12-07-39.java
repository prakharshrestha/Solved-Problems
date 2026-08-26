class Solution {
    public String shortestBeautifulSubstring(String s, int k){

        int left=0;
        int c=0;
        int len=Integer.MAX_VALUE;
        String ans="";

        for (int r=0;r<s.length();r++){

            if (s.charAt(r)=='1')
            c++;

            while (c>k){
                if(s.charAt(left) == '1')
                c--;

                left++;
            }

            while (c==k && s.charAt(left)=='0')
            left++;

            if (c == k){
            String temp = s.substring(left, r + 1);
            if (temp.length()<len||(temp.length()==len && temp.compareTo(ans)<0)){

                ans=temp;
                len=temp.length();
                }
            }
        }
        return ans;
    }
}