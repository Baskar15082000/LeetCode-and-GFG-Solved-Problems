class Solution {
     public void subsetsWithDup(int[] nums,int index,List<Integer>ans,List<List<Integer>> list) {
         list.add(new ArrayList<>(ans));
         for(int i=index;i<nums.length;i++){
             if(i!=index && nums[i]==nums[i-1]) continue;
             ans.add(nums[i]);
             subsetsWithDup(nums,i+1,ans,list);
             ans.remove(ans.size()-1);
         }
         
     }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        subsetsWithDup(nums,0,ans,list); 
        return list;
    }
}