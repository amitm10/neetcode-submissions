class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        for (char b : s.toCharArray()) {
            if (bracketMap.containsKey(b)) {
                if (stack.isEmpty() || stack.peek() != bracketMap.get(b)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(b);
            }
        }
        return stack.isEmpty();
    }
}