//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N,int P, int[][] pre)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++){
            adj.get(pre[i][0]).add(pre[i][1]);
        }
        int in[]=new int[N];
        for(int i=0;i<N;i++){
            for(int val:adj.get(i)){
                in[val]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<N;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(q.size()>0){
            int node=q.remove();
            count++;
            for(int val:adj.get(node)){
                in[val]--;
                if(in[val]==0)q.add(val);
            }
        }
        if(count==N)return true;
        return false;
        
    }
    
}