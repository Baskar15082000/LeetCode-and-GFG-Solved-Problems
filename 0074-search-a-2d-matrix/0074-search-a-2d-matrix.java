class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix[0].length;
        int n=matrix.length;
        int s=0;
        int e=(m*n)-1;
        while(s<=e){
            int mid=(s+e)/2;
            int row=mid/m;
            int col=mid%m;
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col]<target)s=mid+1;
            else e=mid-1;
        }
       
        return false;
    }
}