class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")) {
                stack.add(stack.pop() + stack.pop());
            } else if(tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b - a);
            } else if(tokens[i].equals("*")) {
                stack.add(stack.pop() * stack.pop());
            } else if(tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b / a);
            } else {
                stack.add(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}