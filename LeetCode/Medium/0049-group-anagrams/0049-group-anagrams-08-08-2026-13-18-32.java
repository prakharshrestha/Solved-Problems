class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int n=strs.length;
        HashMap<String,List<String>> ans=new HashMap<>();

        for(int i=0;i<n;i++){
            char[] ch=strs[i].toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);
            if(ans.containsKey(key)){
                ans.get(key).add(strs[i]);
            }
            else{
                List<String> temp=new ArrayList<>();
                temp.add(strs[i]);
                ans.put(key,temp);
            }
        }
        return new ArrayList<>(ans.values());
    }
}