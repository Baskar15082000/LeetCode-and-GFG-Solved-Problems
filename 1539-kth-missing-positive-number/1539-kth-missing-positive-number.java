class Solution {
    public int findKthPositive(int[] arr, int k) {
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int mid=(s+e)/2;
            int missno=arr[mid]-(mid+1);
            if(missno<k){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return e+k+1;
    }
}