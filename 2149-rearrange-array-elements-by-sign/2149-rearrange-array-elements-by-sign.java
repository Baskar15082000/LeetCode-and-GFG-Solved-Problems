class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> q1=new LinkedList<>();
         Queue<Integer> q2=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                q1.add(nums[i]);
            }
            else{
                q2.add(nums[i]);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=q1.remove();
            }
            else{
                nums[i]=q2.remove();
            }
        }
        return nums;
        
    }
}