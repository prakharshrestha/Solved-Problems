class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int l=0;
        char[] ch=s.toCharArray();
        int ans=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for (int r=0;r<n;r++) {
            map.put(ch[r], map.getOrDefault(ch[r],0)+1);

            while(map.get(ch[r])>2) {
                map.put(ch[l], map.getOrDefault(ch[l],0)-1);
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}