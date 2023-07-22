//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void Deleteme(int i,int j,int grid[][]){
	  if(i<0||j<0||i==grid.length||j==grid[0].length||grid[i][j]==0){
		  return;
	  }
	  grid[i][j]=0;
	  Deleteme(i+1,j,grid);
	  Deleteme(i-1,j,grid);
	  Deleteme(i,j-1,grid);
	  Deleteme(i,j+1,grid);
	  
  }

    int numberOfEnclaves(int[][] grid) {

        // Your code here
         for(int j=0;j<grid[0].length;j++){
		  if(grid[0][j]==1)Deleteme(0,j,grid);
		  if(grid[grid.length-1][j]==1)Deleteme(grid.length-1,j,grid);
	  }
	  for(int i=0;i<grid.length;i++){
		 if(grid[i][0]==1) Deleteme(i,0,grid);
		 if(grid[i][(grid[0].length-1)]==1) Deleteme(i,grid[0].length-1,grid);
	  }
	  int count=0;
	  for(int i=0;i<grid.length;i++){
		  for(int j=0;j<grid[0].length;j++){
			  if(grid[i][j]==1)count++;
		  }
	  }
	  return count;
    }
}