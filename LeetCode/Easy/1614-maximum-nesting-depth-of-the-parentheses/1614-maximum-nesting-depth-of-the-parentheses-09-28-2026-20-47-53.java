class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int c=0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                c++;
            }
            if(s.charAt(i)==')'){
                c--;
            }
            ans=Math.max(ans,c);
        }
        return ans;
    }
}