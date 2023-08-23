class Solution {
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
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<pair> q=new LinkedList<>();
        int vis[][]=new int[n][m];
        int ans[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        int r[]={-1,0,1,0};
        int c[]={0,-1,0,1};
        while(q.size()>0){
            pair p=q.remove();
            int row=p.row;
            int col=p.col;
            ans[row][col]=p.dis;
            for(int i=0;i<4;i++){
                int cr=row+r[i];
                int cc=col+c[i];
                if(cr>=0 && cc>=0 && cr<n && cc<m && vis[cr][cc]==0 && mat[cr][cc]==1){
                    vis[cr][cc]=1;
                    q.add(new pair(cr,cc,p.dis+1));
                }
            }
            
        }
        return ans;
        
    }
}