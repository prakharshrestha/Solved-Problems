class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int n=s.length();
        int len=Integer.MAX_VALUE;
        String str="";

        for (int i=0;i<n;i++) {

            if (s.charAt(i)=='1') {

                int r=i+1;
                int count=1;

                while(r<n && count<k) 
                {
                    if (s.charAt(r) == '1')
                    count++;

                    r++;
                }
                if (count==k){

                    String temp=s.substring(i, r);
                    if (temp.length()<len||(temp.length()==len && temp.compareTo(str)<0))
                    {
                        str=temp;
                        len=temp.length();
                    }
                }
            }
        }
        return str;
    }
}