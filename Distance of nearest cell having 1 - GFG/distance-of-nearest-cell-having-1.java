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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    class pair{
        int row;
        int col;
        int dis;
        pair(int row,int col,int dis){
            this.row=row;
            this.col=col;
            this.dis=dis;
        }
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
            int n=grid.length;
            int m=grid[0].length;
            Queue<pair> q=new LinkedList<>();
            int visit[][]=new int[n][m];
            int ans[][]=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==1){
                        visit[i][j]=1;
                        q.add(new pair(i,j,0));
                    }
                }
            }
            int r[]={-1,0,1,0};
		    int c[]={0,-1,0,1};
            while(q.size()>0){
                pair p=q.remove();
                ans[p.row][p.col]=p.dis;
                for(int i=0;i<4;i++){
                    int cr=p.row+r[i];
                    int cc=p.col+c[i];
                    if(cr>=0 && cc>=0 && cr<n && cc<m && visit[cr][cc]==0){
                        visit[cr][cc]=1;
                        q.add(new pair(cr,cc,p.dis+1));
                    }
                }
            }
            return ans;
    }
}