//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {   
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minimumNumberOfSwaps(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int minimumNumberOfSwaps(String S){
        // code here
         int l=0;
		int r=0;
		int swap=0;
		int ib=0;
		for(int i=0;i<S.length();i++){
			
			char ch=S.charAt(i);
			if(ch=='['){
				l++;
				if(ib>0){
					
					swap+=ib;
					ib--;
				}
			}
			if(ch==']'){
				r++;
				ib=(r-l);
			}
			
		}
		return swap;
    }
}