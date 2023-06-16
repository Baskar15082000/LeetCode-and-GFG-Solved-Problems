class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        		Stack<Integer> st=new Stack<>();
		for(int i=0;i<asteroids.length;i++){
			if(asteroids[i]>0){
				st.push(asteroids[i]);
			}
			else {
				while(st.size()>0 &&st.peek()>0 && Math.abs(st.peek())<Math.abs(asteroids[i])){
					st.pop();
				}
				if(st.size()>0 && st.peek()>0 && st.peek()==Math.abs(asteroids[i])){
					st.pop();
				}
				else if(st.size()>0 && st.peek()>0 && st.peek()>Math.abs(asteroids[i]))
                {
					continue;
				}
				else{
					st.push(asteroids[i]);
				}
				
				
			}
			
			}
		int arr[]=new int[st.size()];
		for(int i=arr.length-1;i>=0;i--){
			arr[i]=st.pop();
		}
		return arr;
    }
}