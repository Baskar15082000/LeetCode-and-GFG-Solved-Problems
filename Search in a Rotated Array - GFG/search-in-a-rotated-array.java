//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0;i < n;i++)
            {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());
            
            out.println(new Solution().search(A, 0, n - 1, key));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int a[], int l, int h, int target)
    {
         //Write code here
		int s=0;
		int e=a.length-1;
		while(s<=e){
			int mid=(s+e)/2;
			if(a[mid]==target){
				return mid;
			}
		 if(a[s]<=a[mid]){
				if(target>=a[s] && target<a[mid]){
					e=mid-1;
				}
				else{
					s=mid+1;
				}
			}
			else {
				if(target>a[mid] && target<=a[e]){
					s=mid+1;
				}
				else{
					e=mid-1;
				}
			}
		}
		return -1;
    }
}