class Solution {
    public void dfs(int vis[][],char board[][],int row,int col){
        vis[row][col]=1;
        int n=board.length;
        int m=board[0].length;
        int r[]={-1,0,1,0};
        int c[]={0,-1,0,1};
        for(int i=0;i<4;i++){
            int cr=row+r[i];
            int cc=col+c[i];
            if(cr>=0 && cc>=0 && cr<n && cc<m && board[cr][cc]=='O' && vis[cr][cc]==0){
                
                dfs(vis,board,cr,cc);
            }
        }
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int vis[][]=new int[n][m];
        for(int i=0;i<m;i++){
            if(vis[0][i]==0 && board[0][i]=='O'){
                dfs(vis,board,0,i);
            }
            if(vis[n-1][i]==0 && board[n-1][i]=='O'){
                dfs(vis,board,n-1,i);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i][0] ==0 && board[i][0]=='O'){
                dfs(vis,board,i,0);
            }
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(vis,board,i,m-1);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
        
        
    }
}