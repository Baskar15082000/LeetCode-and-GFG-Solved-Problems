class Solution {
    public boolean ispos(int arr[],int maxo,int p){
        int oper=0;
        for(int val:arr){
            if(val>p){
                if(val%p==0){
                    oper += (val/p)-1; 
                }
                else{
                    oper+=(val/p);
                }
            }
        }
        return oper<=maxo;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int s=1;
        int e=0;
        int ans=0;
        for(int val:nums){
            e=Math.max(e,val);
        }
        while(s<=e){
            int mid=(s+e)/2;
            if(ispos(nums,maxOperations,mid)){
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