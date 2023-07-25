class Solution {
    public int singleNumber(int[] nums) {
        int arr[]=new int[32];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<32;j++){
                if(((nums[i]>>j) & 1)!=0)arr[j]++;
            }
        }
        int ans=0;
        int pow=1;
        for(int i=0;i<32;i++){
            if(arr[i]%3!=0){
                ans+=pow;
            }
            pow*=2;
        }
        return ans;
    }
}