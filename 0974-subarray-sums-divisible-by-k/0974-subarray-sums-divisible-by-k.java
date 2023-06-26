class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int  count=0;
        int  sum=0;
        for(int val:arr){
            sum+=val;
            int rem=sum%k;
            if(rem==0){
                count++;
            }
            if(rem<0){
                rem+=k;
            }
            if(map.containsKey(rem)){
                count+=map.get(rem);
                map.put(rem,map.get(rem)+1);
            }
            else{
                map.put(rem,1);
            }
            
        }
        return count;
        
    }
}