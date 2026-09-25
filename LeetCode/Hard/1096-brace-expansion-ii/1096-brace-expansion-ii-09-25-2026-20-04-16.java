class Solution {

    String s;
    int index;
    public List<String> braceExpansionII(String expression) {
        s = expression;
        index = 0;
        Set<String> result = solve();
        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }
    private Set<String> solve() {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");
        while(index < s.length() && s.charAt(index) != '}') {
            char ch = s.charAt(index);
            if(ch == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                index++;
            } else {
                Set<String> next;
                if(ch == '{') {
                    index++; 
                    next = solve();
                    index++;
                } else {
                    next = new HashSet<>();
                    next.add(String.valueOf(ch));
                    index++;
                }
                Set<String> temp = new HashSet<>();
                for(String a : current) {
                    for(String b : next) {
                        temp.add(a + b);
                    }
                }
                current = temp;
            }
        }
        result.addAll(current);
        return result;
    }
}