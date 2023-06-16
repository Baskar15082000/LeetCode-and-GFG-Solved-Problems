class Solution {
    public int majorityElement(int[] nums) {
       Arrays.sort(nums);
        int max=0;
        
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
                else{
                    break;
                }
            }
            if(count>(nums.length/2) ){
                
                count=count;
                max=nums[i];
                break;
            }
            else{
                count=0;
            }
            
        
        }
        return max;
    }
}