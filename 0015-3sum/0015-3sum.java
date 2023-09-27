class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int t=0-nums[i];
            int s=i+1;
            int e=nums.length-1;
            while(s<e){
                if(nums[s]+nums[e]<t){
                    s++;
                }
                else if(nums[s]+nums[e]>t){
                    e--;
                }
                else{
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[s]);
                    temp.add(nums[e]);
                    list.add(temp);
                    while(s<e && nums[s]==temp.get(1))s++;
                     while(s<e && nums[e]==temp.get(2))e--;
                }
            }
            while(i+1<nums.length && nums[i]==nums[i+1])++i;
        }
        
        
      
        return list;
    }
}