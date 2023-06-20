class Solution {
    public int search(int[] a, int target) {
          //Write code here
		int s=0;
		int e=a.length-1;
		while(s<=e){
			int mid=(s+e)/2;
			if(a[mid]==target){
				return mid;
			}
		 if(a[s]<=a[mid]){
				if(target>=a[s] && target<a[mid]){
					e=mid-1;
				}
				else{
					s=mid+1;
				}
			}
			else {
				if(target>a[mid] && target<=a[e]){
					s=mid+1;
				}
				else{
					e=mid-1;
				}
			}
		}
		return -1;
    }
}