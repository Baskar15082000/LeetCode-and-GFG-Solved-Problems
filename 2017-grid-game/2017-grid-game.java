class Solution {
    public long gridGame(int[][] grid) {
        long arr[][]=new long[2][grid[0].length];
        long sum=0;
        for(int i=grid[0].length-1;i>=0;i--){
            sum+=grid[0][i];
            arr[0][i]=sum;
        }
        sum=0l;
        for(int i=0;i<grid[0].length;i++){
            sum+=grid[1][i];
            arr[1][i]=sum;
        }
       long ans=Long.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            long a=(i+1==arr[0].length?0:arr[0][i+1]);
            long b=(i-1<0?0:arr[1][i-1]);
            long temp=Math.max(a,b);
            ans=Math.min(ans,temp);
        }
        return ans;
    }
}