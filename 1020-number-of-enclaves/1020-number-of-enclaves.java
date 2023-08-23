class Solution {
     class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numEnclaves(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        Queue<pair>q=new LinkedList<>();
        int vis[][]=new int[n][m];
        for(int i=0;i<m;i++){
            if(vis[0][i]==0 && board[0][i]==1){
                vis[0][i]=1;
                q.add(new pair(0,i));
            }
            if(vis[n-1][i]==0 && board[n-1][i]==1){
                vis[n-1][i]=1;
                q.add(new pair(n-1,i));
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i][0] ==0 && board[i][0]==1){
                vis[i][0]=1;
                q.add(new pair(i,0));
            }
            if(vis[i][m-1]==0 && board[i][m-1]==1){
                vis[i][m-1]=1;
                q.add(new pair(i,m-1));
            }
        }
        int r[]={-1,0,1,0};
        int c[]={0,-1,0,1};
        while(q.size()>0){
            pair p=q.remove();
            int row=p.row;
            int col=p.col;
           // if(vis[p.row][p.col]==1)continue;
          //   vis[p.row][p.col]=1;
             for(int i=0;i<4;i++){
               int cr=row+r[i];
               int cc=col+c[i];
               if(cr>=0 && cc>=0 && cr<n && cc<m && board[cr][cc]==1 && vis[cr][cc]==0){
                   vis[cr][cc]=1;
                   q.add(new pair(cr,cc));
                
               }
             }
        }
        int count=0;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==1 && vis[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}