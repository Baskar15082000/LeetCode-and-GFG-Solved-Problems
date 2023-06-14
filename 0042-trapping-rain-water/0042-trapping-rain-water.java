class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int lb=height[0];
        int rb=height[n-1];
        int i=1;
        int j=n-2;
        int totalwater=0;
        while(i<=j){
            if(lb<rb){
                int limit=lb;
                if(limit>height[i]){
                    int water=limit-height[i];
                    totalwater+=water;
                }
                lb=Math.max(lb,height[i]);
                i++;
                
            }
            else{
                int limit=rb;
                if(limit>height[j]){
                    int water=limit-height[j];
                    totalwater+=water;
                }
                rb=Math.max(rb,height[j]);
                j--;
            }
        }
        return totalwater;
    }
}