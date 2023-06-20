//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.searchInsertK(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int searchInsertK(int a[], int N, int b)
    {
        // code here
        int s=0;
		int e=a.length-1;
		int po=-1;
		if(a[0]>b) return 0;
		if(a[e]<b) return e+1;
		while(s<=e){
			int mid=(s+e)/2;
			if(a[mid]==b){
				return mid;
			}
			else if(a[mid]>b){
				po=mid;
				e=mid-1;
			}
			else{
				s=mid+1;
			}
		}
		return po;
    }
}