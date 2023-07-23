class Solution {
    class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] bfs(char grid[][],int row,int col,int visit[][],int n,int m){
        
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
                
                if(dcr>=0 && dcr<n && dcc>=0 && dcc<m && grid[dcr][dcc]=='1' && visit[dcr][dcc]==0){
                
                   
                    q.add(new pair(dcr,dcc));
                }
            }
            
        }
        return visit;
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int visit[][]=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && visit[i][j]==0){
                    count++;
                    visit=bfs(grid,i,j,visit,n,m);
                        
                    

                    
                }
            }
        }
        return count;

            }
}