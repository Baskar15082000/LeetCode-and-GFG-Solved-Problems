class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output; 
    public MyQueue() {
       input= new Stack<Integer>(); 
        output=new Stack<Integer>();
    }
    
    public void push(int x) {
          while(input.size()>0){
	       output.push(input.pop());
	      }
          if(input.size()==0){
	       input.push(x);
	      }
          
          while(output.size()>0){
	       input.push(output.pop());
	     }
        
    }
    
    public int pop() {
        
	  return input.pop();
    }
    
    public int peek() {
        return input.peek();
    }
    
    public boolean empty() {
        if(input.size()==0) return true;
        return false;
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