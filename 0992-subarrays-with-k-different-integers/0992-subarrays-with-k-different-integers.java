class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
            return atMostK(nums, k) - atMostK(nums, k - 1);
        
     
    }
 private int atMostK(int[] nums, int k) {
     int s=0;
     int e=0;
     int count=0;
     int d=0;
      Map<Integer, Integer> map = new HashMap<>();
     while(e<nums.length){
         if(!map.containsKey(nums[e]) || map.get(nums[e])==0){
             d++;
         }
         map.put(nums[e],map.getOrDefault(nums[e],0)+1);
         while(d>k){
             map.put(nums[s],map.get(nums[s])-1);
             if(map.get(nums[s])==0){
                 d--;
             }
             s++;
         }
         count+=e-s+1;
         e++;
     }
     return count;
 }
}