//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    static class pair{
        int row;
        int col;
		int time;
        pair(int row,int col ,int time){
            this.row=row;
            this.col=col;
			this.time=time;
        }
    }
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here 
        int n=grid.length;
		 int m=grid[0].length;
		int vis[][]=new int [n][m]; 
		 int countfresh=0;
		 Queue<pair> q=new LinkedList<>();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(grid[i][j]==2){
					vis[i][j]=2;
					q.add(new pair(i,j,0));
				}
				if(grid[i][j]==1){
					countfresh++;
				}
			}
		}
		int rotten=0;
		 int time=0;
		while(q.size()>0){
			pair p=q.remove();
			time=Math.max(time,p.time);
			int r[]={-1,0,1,0};
			int c[]={0,-1,0,1};
			for(int i=0;i<4;i++){
				int cr=p.row+r[i];
				int cc=p.col+c[i];
				if(cr>=0 && cc>=0 && cr<n && cc<m && grid[cr][cc]==1 && vis[cr][cc]==0 ){
					vis[cr][cc]=2;
					rotten++;
					q.add(new pair(cr,cc,p.time+1));
					
				}
			}
		}
		 if(rotten<countfresh)return -1;
		 return time;
    }
}