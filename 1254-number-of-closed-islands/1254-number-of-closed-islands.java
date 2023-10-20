class Solution {
    public int closedIsland(int[][] grid) {
      int n=grid.length;
      int m=grid[0].length;
      for(int j=0;j<m;j++){
          dfs(grid,0,j);//top 
          dfs(grid,n-1,j);//bottom
      }
      for(int i=0;i<n;i++){
          dfs(grid,i,0);
          dfs(grid,i,m-1);
      }
      int count=0;
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(grid[i][j]==0){
                  count++;
                  dfs(grid,i,j);
              }
          }
      }
        return count;
      
        
    }
    public void dfs(int [][] grid,int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        
        if(i<0 || j<0 || i>=n || j>=m){
            return; //out of boundry
        }
        if(grid[i][j]==1){
            return ;//already maek
        }
        
        grid[i][j]=1;
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
            
        }
    
}