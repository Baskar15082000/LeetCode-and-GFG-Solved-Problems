class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
         HashMap<Integer,Integer> map=new HashMap<>();
		int c=0;
		
		int count=0;
		for(int i=0;i<nums.length;i++){
	
			
            if(nums[i]%2==1)c++;
            if(c==k)count++;
			
			if(map.containsKey(c-k)){
				count+=map.get(c-k);
				
			}
            map.put(c,map.getOrDefault(c,0)+1);
		
	
		}
		return count;
    }
}