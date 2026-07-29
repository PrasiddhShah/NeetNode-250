class Solution {
    public String decodeString(String s) {
        Stack<Integer> times = new Stack<>();
        Stack<StringBuilder> st_stack = new Stack<>();
        StringBuilder st = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                sum = sum * 10 + (ch - '0');
            } else if (ch == '[') {
                times.push(sum);
                st_stack.push(st);
                st = new StringBuilder();
                sum = 0;
            } else if (ch == ']') {
                int time = times.pop();
                StringBuilder decoded = new StringBuilder();
                for (int j = 0; j < time; j++) {
                    decoded.append(st);
                }
                StringBuilder parent = st_stack.pop();
                st = parent.append(decoded);
            } else {
                st.append(ch);
            }
        }
        return st.toString();
    }
}