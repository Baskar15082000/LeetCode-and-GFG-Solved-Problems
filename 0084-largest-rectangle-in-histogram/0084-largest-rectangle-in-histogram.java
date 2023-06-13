class Solution {
    public  int[] left(int[] heights){
        int left[]=new int[heights.length];
        Stack<Integer> st=new Stack<>();
        for(int i= heights.length-1;i>=0;i--){
            while(st.size()>0 && heights[i]<heights[st.peek()]){
                left[st.pop()]=i;
            }
            st.push(i);
        }
        while(st.size()>0){
            left[st.pop()]=-1;
        }
        return left;
    }
    public  int[] right(int[] heights){
        int right[]=new int[heights.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(st.size()>0 && heights[i]<heights[st.peek()]){
                right[st.pop()]=i;
            }
            st.push(i);
        }
        while(st.size()>0){
            right[st.pop()]=heights.length;
        }
        return right;
    }
    public int largestRectangleArea(int[] heights) {
        int left[]=left(heights);
        int right[]=right(heights);
        int maxarea=0;
        for(int i=0;i<heights.length;i++){
            int width=right[i]-left[i]-1;
            int area=width*heights[i];
            maxarea=Math.max(area,maxarea);
        }
        return maxarea;
    }
}