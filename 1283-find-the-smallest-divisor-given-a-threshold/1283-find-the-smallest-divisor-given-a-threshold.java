class Solution {
    int ispos(int mid,int nums[]){
        int sum=0;
        for(int i:nums){
            sum += (Math.ceil((double)i/(double)mid));
            
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int th) {
        int s=1;
        int e=0;
        for(int i:nums){
            e=Math.max(i,e);
        }
        int ans=0;
        while(s<=e){
            int mid=(s+e)/2;
            int t=ispos(mid,nums);
            if(t<=th){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
}