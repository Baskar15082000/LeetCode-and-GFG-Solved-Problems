class NumMatrix {
    int sum[][];
    
    public NumMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        sum=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int a=matrix[i][j];
                int b=(j-1<0?0:sum[i][j-1]);
                int c=(i-1<0?0:sum[i-1][j]);
                int d=(i-1 <0|| j-1<0 ?0:sum[i-1][j-1]);
                sum[i][j]=a+b+c-d;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a=sum[row2][col2];
        int b=(col1-1<0?0:sum[row2][col1-1]);
        int c=(row1-1<0?0:sum[row1-1][col2]);
        int d=(row1-1<0|| col1-1<0 ?0:sum[row1-1][col1-1]);
        return a-b-c+d;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */