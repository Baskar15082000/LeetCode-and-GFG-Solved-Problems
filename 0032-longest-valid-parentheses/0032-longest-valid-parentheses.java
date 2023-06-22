class Solution {
    public int longestValidParentheses(String s) {
        		Stack<Integer> in=new Stack<>();
		Stack<Character> c=new Stack<>();
		in.push(-1);
		int ans=0;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(ch=='('){
				c.push('(');
				in.push(i);
			}
			else{
				if(in.size()>0 && c.size()>0 && ch==')' ){
					c.pop();
					in.pop();
					ans=Math.max(ans,i-in.peek());
				}
				else{
					in.push(i);
				}
			}
		}
		return ans;
    }
}