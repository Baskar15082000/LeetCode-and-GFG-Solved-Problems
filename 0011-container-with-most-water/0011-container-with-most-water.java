class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int totalwater=0;
        while(i<j){
            int h=Math.min(height[i],height[j]);
            int w=j-i;
            int water=h*w;
            totalwater=Math.max(totalwater,water);
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return totalwater;
    }
}