class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        HashMap<String, String> map = new HashMap<>();
        for (List<String> k : knowledge) {
            map.put(k.get(0), k.get(1));
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(') {
                ans.append(s.charAt(i));
            } 
            else {
                int j = i + 1;
                StringBuilder key = new StringBuilder();
                while (s.charAt(j) != ')') {
                    key.append(s.charAt(j));
                    j++;
                }
                String value = map.getOrDefault(key.toString(), "?");
                ans.append(value);
                i = j;
            }
        }
        return ans.toString();
    }
}