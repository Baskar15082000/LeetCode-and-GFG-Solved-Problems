class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int val:nums){
            if(set.contains(val)){
                ans.add(val);
            }
            else{
                set.add(val);
            }
        }
        return ans;
    }
}