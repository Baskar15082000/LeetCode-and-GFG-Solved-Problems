class Solution {
    public String reverseParentheses(String s) {
          Stack<Character> st=new Stack<>();
	Deque<Character> st1=new ArrayDeque<>();
	  String str="";
	  for(int i=0;i<s.length();i++){
		  char ch=s.charAt(i);
		  if(ch!=')'){
			  st.push(ch);
		  }
		  else if(st.size()>0 && ch==')') {
			  while(st.size()>0 && st.peek()!='('){
				 //System.out.print(st.peek());
				 st1.addLast( st.pop() );
			  }
			  if(st.size()>0 && st.peek()=='('){
				  
	                st.pop();
			  }
			  
			  while(st1.size()>0){
				  
				  st.push(st1.removeFirst());
			  }
			  
			  
		  }
	  }
	  str="";
	  while(st.size()>0){
		  if(st.peek()!='('){
			  
		    str=st.peek()+str;
		  }
		  st.pop();
	  }
	  return str;
    }
}