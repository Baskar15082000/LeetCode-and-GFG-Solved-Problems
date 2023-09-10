//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 

{
    static  boolean ispos(int mid,int A[],int M){
        int st=1;
        int sum=0;
        for(int i:A){
            if((sum+i) <= mid){
                sum+=i;
            }
            else{
                st++;
                sum=i;
            }
        }
        return st<=M;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        int s=0;
        int e=0;
        for(int i:A){
            s=Math.max(s,i);
            e+=i;
        }
        if(M>N)return -1;
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(ispos(mid,A,M)){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
};