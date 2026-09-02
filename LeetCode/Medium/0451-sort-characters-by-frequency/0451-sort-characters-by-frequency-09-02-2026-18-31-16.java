class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> freq=new HashMap<>();
        
        for(char ch:s.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        List<Map.Entry<Character,Integer>> ans=new ArrayList<>(freq.entrySet());
        ans.sort((a,b)->b.getValue()-a.getValue());
        String r="";
        for(Map.Entry<Character,Integer> x: ans){
            for(int i=0;i<x.getValue();i++){
                r+=x.getKey();
            }
        }
        return r;
    }
}