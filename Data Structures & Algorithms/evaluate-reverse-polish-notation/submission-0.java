class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }

        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]); 
        }

        Stack<Integer> in = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];  
            if (in.size() > 1 && (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))) {
                int second = in.pop();
                int first = in.pop();

                switch (token.charAt(0)) {  
                    case '+':
                        in.push(first + second);
                        break;
                    case '-':
                        in.push(first - second);
                        break;
                    case '*':
                        in.push(first * second);
                        break;
                    case '/':
                        in.push(first / second);
                        break;
                }
            } else {
                in.push(Integer.parseInt(token));
            }
        }

        return in.pop();
    }
}
