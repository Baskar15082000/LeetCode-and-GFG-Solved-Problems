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
    public static boolean ispossible(int A[],int maxstu,int limit){
        int noofstu=1;
        int sum=0;
        for(int a:A){
            if(sum+a<=limit){
                sum+=a;
            }
            else{
                noofstu++;
                sum=a;
            }
        }
        return noofstu<=maxstu;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int n,int stu)
    {
        //Your code here
       // System.out.print(stu);
        int s=0;
        int e=0;
        int ans=0;
        if(stu>A.length)return -1;
        for(int a:A){
            s=Math.max(s,a);
            e+=a;
        }
        while(s<=e){
            int mid=(s+e)/2;
            if(ispossible(A,stu,mid)){
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