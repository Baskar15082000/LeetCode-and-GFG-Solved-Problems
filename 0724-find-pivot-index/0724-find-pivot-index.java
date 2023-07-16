class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			nums[i]=sum;
		}
		for(int i=0;i<nums.length;i++){
			int a=(i-1<0?0:nums[i-1]);
			int b=nums[nums.length-1]-nums[i];
			if(a==b){
				return i;
			}
		}
		return -1;
    }
}