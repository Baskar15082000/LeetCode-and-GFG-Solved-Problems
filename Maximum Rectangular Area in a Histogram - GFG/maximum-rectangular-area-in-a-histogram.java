//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
     public  static int[] left(long[] heights){
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
     public static int[] right(long[] heights){
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
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {

        int left[]=left(hist);
        int right[]=right(hist);
        long maxarea=0;
        for(int i=0;i<hist.length;i++){
            long width=right[i]-left[i]-1;
            long area=width*hist[i];
            maxarea=Math.max(area,maxarea);
        }
        return maxarea;
        
    }
        
}



