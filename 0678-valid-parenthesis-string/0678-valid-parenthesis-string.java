class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer>os=new Stack<>();
		Stack<Integer>star=new Stack<>();
		if(s.charAt(0)==')')return false;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(ch=='('){
				os.push(i);
			}
			else if(os.size()>0 && ch==')' && s.charAt(os.peek())=='('){
			     os.pop();
			}
			else if(ch=='*'){
				star.push(i);
			}
			else if(os.size()==0 && s.charAt(i)==')' && star.size()==0){
				return false;
			}else if(star.size()>0 && s.charAt(i)==')'){
                star.pop();
            }
			
		}
		
	
		if(os.size()==0 )return true;
		while(os.size()>0 && star.size()>0){
			if(s.charAt(os.peek())=='(')
			{
			if(os.peek()<star.peek() ){
				os.pop();
				star.pop();
			}else{
				
				break;
			}
				
			}
			else if(s.charAt(os.peek())==')'){
				if(os.peek()>star.peek()){
				os.pop();
				star.pop();
			}
				else{
				
					break;
				}
				
			}
			
		}
		if(os.size()==0)return true;
        
		return false;
    }
}