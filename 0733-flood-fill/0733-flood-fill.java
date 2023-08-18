class Solution {
    public void dfs(int ro,int co,int[][] image,int ans[][], int row[], int col[],int currcolor, int color){
        ans[ro][co]=color;
        for(int i=0;i<4;i++){
            int r=ro+row[i];
            int c=co+col[i];
            if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]==currcolor && ans[r][c]!=color){
                
                dfs(r,c,image,ans,row,col,currcolor,color);
            }
        }
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ans[][]=image;
        int currcolor=image[sr][sc];
        int row[]={-1,0,1,0};
        int col[]={0,-1,0,1};
        dfs(sr,sc,image,ans,row,col,currcolor,color);
        return ans;
    }
}