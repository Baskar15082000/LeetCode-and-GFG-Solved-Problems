class Solution {
    public long countSubarrays(int[] nums, long k) {
        int s=0;
		int e=0;
		long sum1=0;
        long sum2=0;
		long ans=0;
		while(e<nums.length){
		   sum1=sum1+nums[e];
           sum2=sum1*(e-s+1);
		   while(sum2>=k ){
			  
               sum1=sum1-nums[s];
               sum2=sum1*(e-s);
         	   s++;
         }
		   
		   ans=ans+(e-s+1);
		   e++;
		
		}
		  
		return ans;
    
    }
}