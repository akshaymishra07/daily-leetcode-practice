class MinStack {
  
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int top;
    
    public MinStack() {
        
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        
        
        stack.add(val);
        
        if(minStack.empty()){
            minStack.push(val);
        }else if(!minStack.empty() && val <= minStack.peek()){
           minStack.push(val);    
        }
        
        
    }
    
    public void pop() {
    
        int n = stack.pop();
        
        if(!minStack.empty() && n == minStack.peek()){
            minStack.pop();
        }
        
    }
    
    
    public int top() {
       return stack.peek();
    }
    
    public int getMin() {
       
        if(!minStack.empty()){
          return minStack.peek();   
       } 
       
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */