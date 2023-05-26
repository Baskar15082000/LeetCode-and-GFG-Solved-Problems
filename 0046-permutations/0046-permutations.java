class Solution {
     public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        
             permute(nums,0,list);
         return list;
         
    }
    public void swap(int i,int j,int nums[]){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public List<List<Integer>> permute(int []nums,int index,List<List<Integer>> list) {
        if(index==nums.length){
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ans.add(nums[i]);
            }
            list.add(new ArrayList<>(ans));
            return list;
        }
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            permute(nums,index+1,list);
            swap(i,index,nums);
            
        }
        return list;
    }
}