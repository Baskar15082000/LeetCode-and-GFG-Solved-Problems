class MinStack {
    Stack<Integer> st;
    Stack<Integer> st1;
    int min;
    public MinStack() {
        st=new Stack<>();
        st1=new Stack<>();
        min=Integer.MAX_VALUE;
        
    }
    
    public void push(int val) {
        // if(st1.size()==0){
        //     st1.push(val);
        // }
        // else if(val<=st1.peek()){
            
        
        //     st1.push(val);
            
        // }
       
        // st.push(val);
        
         st.push(val);

        if (val <= min) {
            st1.push(val);
            min = val;
        }
    }
    
    public void pop() {
       
        
        //     if(st1.peek()==st.peek()){
        //         st1.pop();
        //     }
        
        // st.pop();
        
        int popped = st.pop();

        if (popped == min) {
            st1.pop();
            if (st1.isEmpty()) {
                min = Integer.MAX_VALUE;
            } else {
                min = st1.peek();
            }
        }
       
    }
    
    public int top() {
        
        return st.peek();
    }
    
    public int getMin() {
       
        return st1.peek();
    }
}