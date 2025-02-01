class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        if(q1.isEmpty()){
            q1.add(x);
            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }
        else{
            q2.add(x);
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
        }
    }
    
    public int pop() {
        if(!q1.isEmpty()){
            return q1.remove();
        }
        else{
            return q2.remove();
        }
    }
    
    public int top() {
        if(!q1.isEmpty()){
            return q1.peek();
        }
        else{
            return q2.peek();
        }
        
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
