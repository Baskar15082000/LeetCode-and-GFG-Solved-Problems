class Solution {
    public int subarraySum(int[] Arr, int K) {
         HashMap<Integer,Integer> map=new HashMap<>();
		// Write your code here

    
		int sum=0;
		int count=0;
		for(int i=0;i<Arr.length;i++){
			sum+=Arr[i];
			if(sum==K){
				count++;
			}
			if(map.containsKey(sum-K)){
				
				count+=map.get(sum-K);
				
			}
			if(map.containsKey(sum)){
				map.put(sum,map.get(sum)+1);
			}
			else{
				map.put(sum,1);
			}
		}
        return count;
    }
}