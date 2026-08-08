class MyStack {
    Queue<Integer> q1 = new LinkedList<>();//2 linked lists
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q2.add(x);//add to q2 FIFO
        while (!q1.isEmpty()) {
            q2.add(q1.remove());//empty q1 fromm last element and add it to q2
        }
        Queue<Integer> temp = q1;//q1 is empty here
        q1 = q2;//put back all the elements again in q1
        q2 = temp;//
    }
    
    public int pop() {
        return q1.remove();//no changes in pop both are first out
    }
    
    public int top() {
        return q1.peek();//No changes in peek both are first out
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}