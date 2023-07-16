class Solution {
    public int maxSubArray(int[] nums) {
        int train=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int newt=nums[i];
            int pre=train+nums[i];
            train=Math.max(newt,pre);
            ans=Math.max(ans,train);
        }
        return ans;
    }
}