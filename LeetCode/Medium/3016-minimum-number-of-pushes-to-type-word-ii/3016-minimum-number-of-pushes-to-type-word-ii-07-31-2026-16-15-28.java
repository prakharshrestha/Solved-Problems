class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        HashMap<Character,Integer> ans=new HashMap<>();

        for(char ch: word.toCharArray()){
            ans.put(ch,ans.getOrDefault(ch,0)+1);
        }
        ArrayList<Map.Entry<Character,Integer>> res= new ArrayList<>(ans.entrySet());

        Collections.sort(res,(a,b)->b.getValue()-a.getValue());

        int c=0;

        for(int i=0;i<res.size();i++){
            int f=res.get(i).getValue();
            int val=(i/8)+1;
            c+=val*f;
        }
        return c;
    }
}