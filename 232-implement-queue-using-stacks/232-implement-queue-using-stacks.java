class MyQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    int front;
    
    
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
        front = -1;
    }
    
    public void push(int x) {
        
        if(pushStack.empty()){
            
            front = x;
            pushStack.push(x);
            return;
        }
        
        
        pushStack.push(x);
    }
    
    public int pop() {
        
         
        
        while(!pushStack.empty()){
            
          popStack.push(pushStack.pop());    
            
        }
        
        
        
        int n = popStack.pop();
        
        if(popStack.empty()){
            front = -1;
            
            return n;
        }
        
        
        
        front = popStack.peek();
        
         while(!popStack.empty()){
            
          pushStack.push(popStack.pop());    
            
        }
        
        
        return n;
    }
    
    public int peek() {
        
        return front;
        
    }
    
    public boolean empty() {
       
        return pushStack.empty() && popStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */