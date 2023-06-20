class Solution {
    public int searchInsert(int[] arr, int target) {
        int s=0;
        int e=arr.length-1;
        if(arr[0]>target)return 0;
        
        if(arr[e]<target) return e+1;
        int po=0;
        while(s<=e){
            int mid=(s+e)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                po=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
            
        }
        return po;
    }
}