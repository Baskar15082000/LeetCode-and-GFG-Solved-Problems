class Solution {
    public int[] singleNumber(int[] nums) {
        		if(nums.length==2)return nums;
        // write code here
		int arr[]=new int [2];
		int sum=0;
		for(int i=0;i<nums.length;i++){
			sum^=nums[i];
		}
		sum=(sum & -sum);
		for(int i=0;i<nums.length;i++){
			if((sum & nums[i])>0)arr[0]=arr[0]^nums[i];
			else arr[1]=arr[1]^nums[i];
		}
		Arrays.sort(arr);
		
		return arr;
    }
}