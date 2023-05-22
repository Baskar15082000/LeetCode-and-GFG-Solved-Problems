class Solution {
//	static List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target,int index,List<Integer>list,List<List<Integer>> ans){
        if(index==candidates.length){
			if(target==0){
				ans.add(new ArrayList<>(list));
			}
			return ans;
		}
		
		if(candidates[index]<=target){
			list.add(candidates[index]);
			combinationSum(candidates, target-candidates[index],index,list,ans );
			list.remove(list.size()-1);
		}
		combinationSum(candidates, target,index+1,list,ans );
		return ans;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list=new ArrayList<>();
				List<List<Integer>> ans=new ArrayList<>();
        return combinationSum(candidates,target,0,list,ans);
    }
}