
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char opening = stack.pop();

                if (ch == ')' && opening != '(' ||
                    ch == ']' && opening != '[' ||
                    ch == '}' && opening != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}