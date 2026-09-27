class Solution {
    public String reverseParentheses(String s) {

        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder r = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(r);
                r = new StringBuilder();
            } else if(ch == ')') {
                r.reverse();
                StringBuilder temp = stack.pop();
                temp.append(r);
                r = temp;
            } else {
                r.append(ch);
            }
        }
        return r.toString();
    }
}