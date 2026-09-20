class Solution {
    public int reverseDegree(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        String str="abcdefghijklmnopqrstuvwxyz";
        int j=1;
        for(int i=25;i>=0;i--){
            map.put(str.charAt(i),j);
            j++;
        }
        int ans=0;
        for(int i=0;i<s.length();i++){
            ans=ans+map.get(s.charAt(i))*(i+1);
        }
        return ans;
    }
}