class Solution {
     public List<List<Integer>> subsets(int[] nums,int index,List<Integer> ans,List<List<Integer>> list) {
         if(index==nums.length){
             list.add(new ArrayList<>(ans));
             return list;
         }
         subsets(nums,index+1,ans,list);
         ans.add(nums[index]);
         subsets(nums,index+1,ans,list);
         ans.remove(ans.size()-1);
         return list;
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        subsets(nums,0,ans,list);
        return list;
    }
}