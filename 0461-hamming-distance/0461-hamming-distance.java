class Solution {
    public int hammingDistance(int x, int y) {
        int dis=x^y;
        int count=0;
        while(dis>0){
            if((dis & 1)>0){
                count++;
            }
            dis=dis>>1;
        }
        return count;
    }
}