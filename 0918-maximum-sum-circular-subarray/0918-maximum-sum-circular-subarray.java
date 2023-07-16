class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        		int trainmax=0;
		int trainmin=0;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		int total=0;
		for(int i=0;i<arr.length;i++){
			total+=arr[i];
			int pre1=trainmax+arr[i];
			int newt=arr[i];
			int pre2=trainmin+arr[i];
			trainmax=Math.max(pre1,newt);
			max=Math.max(max,trainmax);
			trainmin=Math.min(pre2,newt);
			min=Math.min(trainmin,min);
			
		}
		int around=total-min;
		if(total==min)return max;
		return Math.max(around,max);

    }
}