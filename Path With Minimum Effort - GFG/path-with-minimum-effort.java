//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
     class pair{
	  int row;
	  int col;
	  int dif;
	  pair(int row,int col,int dif){
		  this.row=row;
		  this.col=col;
		  this.dif=dif;
	  }
  }
    
    int MinimumEffort(int heights[][]) {
        	  int n=heights.length;
	  int m=heights[0].length;
	  int visit[][]=new int[n][m];
	  for(int i=0;i<n;i++){
		  for(int j=0;j<m;j++){
			  visit[i][j]=Integer.MAX_VALUE;
		  }
	  }
	  visit[0][0]=0;
	  PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
		  return a.dif-b.dif;
	  });
	  int r[]={-1,0,1,0};
	  int c[]={0,-1,0,1};
	  pq.add(new pair(0,0,0));
	  while(pq.size()>0){
		  pair p=pq.remove();
		  int row=p.row;
		  int col=p.col;
		  int dif=p.dif;
		  if(row==n-1 && col==m-1)return dif;
		  for(int i=0;i<4;i++){
			  int cr=row+r[i];
			  int cc=col+c[i];
			  if(cr>=0 && cc>=0 && cr<n && cc<m){
				  
			  int newdif=Math.max(Math.abs(heights[cr][cc]-heights[row][col]),dif);
			   if(newdif<visit[cr][cc]){
				   visit[cr][cc]=newdif;
				   pq.add(new pair(cr,cc,newdif));
			   }
			  }
			  
		  }
	  }
	  return 0;
    }
}