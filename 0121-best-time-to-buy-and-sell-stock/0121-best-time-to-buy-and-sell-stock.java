class Solution {
    public int maxProfit(int[] p) {
        int ans=0;
        int result=0;
        int val=p[0];
        for(int i=1;i<p.length;i++){
            if(val>p[i]){
                val=p[i];
            }
            else if(val<p[i]){
                result=Math.max(result,p[i]-val);
            }
        }
        return result;
    }
}