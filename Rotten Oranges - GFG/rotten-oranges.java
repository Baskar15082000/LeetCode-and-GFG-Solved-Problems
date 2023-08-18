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
    //Function to find minimum time required to rot all oranges. 
   class pair{
        int row;
        int col;
        int time;
        pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid)
    
    {
        int n=grid.length;
        int m=grid[0].length;
        int ans[][]=new int[n][m];
        Queue<pair> q=new LinkedList<>();
        int ft=0;
         int delrow[]={-1,0,1,0};
        int delcol[]={0,-1,0,1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    ans[i][j]=2;
                    q.add(new pair(i,j,0));
                }
                if(grid[i][j]==1)ft++;
            }
        }
        int rt=0;
        int time=0;
    
        while(q.size()>0){
            pair p=q.remove();
            time=Math.max(p.time,time);
            int r=p.row;
            int c=p.col;
            for(int i=0;i<4;i++){
                int cr=r+delrow[i];
                int cc=c+delcol[i];
                if(cr>=0 && cr<n && cc>=0 && cc<m && grid[cr][cc]==1 && ans[cr][cc]==0){
                    rt++;
                    ans[cr][cc]=2;
                    q.add(new pair(cr,cc,p.time+1));
                }
            }
        }
        if(ft!=rt)return -1;
        return time;
    }
}