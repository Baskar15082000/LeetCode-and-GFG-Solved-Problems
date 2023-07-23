//{ Driver Code Starts
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
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
        class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
     public void bfs(int grid[][],int row,int col,int visit[][],int n,int m,ArrayList<Integer>s){
		
        s.add(row-row);
		s.add(col-col);
        int delrow[]={-1,0,1,0};
        int delcol[]={0,-1,0,1};
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(row,col));
        while(q.size()>0){
            
            pair p=q.remove();
            int cr=p.row;
            int cc=p.col;
            
             if(visit[cr][cc]==1)continue;
            visit[cr][cc]=1;
			
            for(int i=0;i<4;i++){
                 
               int dcr=cr+delrow[i];
               int  dcc=cc+delcol[i];
                
                if(dcr>=0 && dcr<n && dcc>=0 && dcc<m && grid[dcr][dcc]==1 && visit[dcr][dcc]==0){
                
                    
					s.add(row-dcr);
					s.add(col-dcc);
                    q.add(new pair(dcr,dcc));
                }
            }
            
        }
    
    }


    int countDistinctIslands(int[][] grid) {
        // Your Code here
        	   int n=grid.length;
        int m=grid[0].length;
        int visit[][]=new int[n][m];
        HashSet<ArrayList<Integer>> st=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visit[i][j]==0){
                    
					ArrayList<Integer> s=new ArrayList<>();
                    bfs(grid,i,j,visit,n,m,s);
					st.add(s);
                        
                    

                    
                }
            }
        }
        return st.size();
    }
}
