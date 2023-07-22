class Solution {
    public void Deleteme(int i,int j,int grid[][]){
	  if(i<0||j<0||i==grid.length||j==grid[0].length||grid[i][j]==0){
		  return;
	  }
	  grid[i][j]=0;
	  Deleteme(i+1,j,grid);
	  Deleteme(i-1,j,grid);
	  Deleteme(i,j-1,grid);
	  Deleteme(i,j+1,grid);
	  
  }
    public int numEnclaves(int[][] grid) {
         for(int j=0;j<grid[0].length;j++){
		  if(grid[0][j]==1)Deleteme(0,j,grid);
		  if(grid[grid.length-1][j]==1)Deleteme(grid.length-1,j,grid);
	  }
	  for(int i=0;i<grid.length;i++){
		 if(grid[i][0]==1) Deleteme(i,0,grid);
		 if(grid[i][(grid[0].length-1)]==1) Deleteme(i,grid[0].length-1,grid);
	  }
	  int count=0;
	  for(int i=0;i<grid.length;i++){
		  for(int j=0;j<grid[0].length;j++){
			  if(grid[i][j]==1)count++;
		  }
	  }
	  return count;
    }
}