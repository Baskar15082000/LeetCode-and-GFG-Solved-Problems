class Solution {
    public int longestConsecutive(int[] arr) {

	
	   // add your code here
	   HashSet<Integer> set=new HashSet<>();
	   for(int val:arr){
	       set.add(val);
	   }
	   int fincount=0;
	   for(int val:arr){
	       int n=val;
	       if(!set.contains(n-1)){
	           int count=1;
	           while(set.contains(n+1)){
	               n++;
	               count++;
	           }
	           fincount=Math.max(fincount,count);
	       }
	   }
	   return fincount;
    }
}