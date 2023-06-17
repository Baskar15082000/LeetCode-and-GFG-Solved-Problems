class Solution {
    public String smallestNumber(String pattern) {
         Stack<Integer> stack = new Stack<>();
		int num = 1;
		String ans = "";
		for(int i = 0; i < pattern.length(); i++)
			{
				stack.push(num);
				num++;
				if(pattern.charAt(i) == 'I')
				{
					while(stack.size() > 0)
						{
							ans = ans+stack.pop();
						}
				}
			}
		stack.push(num);
		while(stack.size() > 0)
			{
				ans = ans + stack.pop();
			}
		return ans;
    }
}