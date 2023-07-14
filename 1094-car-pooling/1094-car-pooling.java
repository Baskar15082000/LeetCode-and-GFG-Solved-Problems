class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int pre[]=new int[10001];
        for(int i=0;i<trips.length;i++){
            int a=trips[i][0];
            int l=trips[i][1];
            int r=trips[i][2];
            pre[l]+=a;
            pre[r]-=a;
        }
        int sum=0;
        for(int i=0;i<pre.length;i++){
            sum+=pre[i];
            pre[i]=sum;
            if(pre[i]>capacity)return false;
        }
        return true;
    }
}