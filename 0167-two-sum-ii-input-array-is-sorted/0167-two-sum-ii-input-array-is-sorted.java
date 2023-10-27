class Solution {
    public int[] twoSum(int[] num, int target) {
         int ans[]=new int[2];
         int i=0;
        int j=num.length-1;
         while(i<j){
             if(num[i]+num[j]==target){
                 ans[0]=i+1;
                 ans[1]=j+1;
                 return ans;
             }
             if(num[i]+num[j]>target){
                 j--;
             }
             else{
                 i++;
             }
         }
        return ans;
    }
}