class Solution {
    public int calPoints(String[] operations) {
    Stack<Integer> stack = new Stack<>();
    
    for (String op : operations) {
        if (op.equals("+")) {
            // Need the last two scores
            int last = stack.pop();
            int secondLast = stack.peek();
            int sum = last + secondLast;
            stack.push(last);      // Push back the one we popped
            stack.push(sum);       // Push the new sum
        } else if (op.equals("D")) {
            stack.push(2 * stack.peek());
        } else if (op.equals("C")) {
            stack.pop();
        } else {
            // It's a number
            stack.push(Integer.parseInt(op));
        }
    }
    
    // Sum all remaining scores
    int total = 0;
    for (int score : stack) {
        total += score;
    }
    return total;
}
}