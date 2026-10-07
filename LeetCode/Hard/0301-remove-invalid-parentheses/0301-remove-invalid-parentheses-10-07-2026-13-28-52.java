class Solution {

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);
        boolean found = false;
        while(!queue.isEmpty() && !found) {

            int size = queue.size();
            for(int k = 0; k < size; k++) {
                String curr = queue.poll();
                if(isValid(curr)) {
                    ans.add(curr);
                    found = true;
                    continue;
                }
                if(found)
                    continue;
                for(int i = 0; i < curr.length(); i++) {

                    char ch = curr.charAt(i);
                    if(ch != '(' && ch != ')')
                        continue;
                    String next =
                        curr.substring(0, i) +
                        curr.substring(i + 1);

                    if(!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
        }
        return ans;
    }
    public boolean isValid(String s) {
        int balance = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                balance++;
            }
            else if(ch == ')') {
                balance--;
                if(balance < 0)
                    return false;
            }
        }
        return balance == 0;
    }
}