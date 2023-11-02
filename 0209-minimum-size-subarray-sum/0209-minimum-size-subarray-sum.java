class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int s=0;
        int e=0;
        int sum=0;
        int length=nums.length+1;
        while(e<nums.length){
            sum+=nums[e];
            while(sum>=target){
              length= Math.min(length,e-s+1);
              sum -=nums[s];
              s++;
               
           }
            
            e++;
            
        }
        if(length==nums.length+1)return 0;
        return length;
    }
}