class Solution {
    public int[] searchRange(int[] v, int k) {
        int arr[]=new int[2];
        arr[0]=-1;
        arr[1]=-1;
        
        
 int n=v.length;
        int f=-1;
		int s=0,e=n-1;
		while(s<=e){
			int mid=(s+e)/2;
			if(v[mid]==k){
				f=mid;
				e=mid-1;
			}
			else if(v[mid]>k){
				e=mid-1;
			}
			else{
				s=mid+1;
			}
			
		}

		int se=-1;
	    s=0;
		e=n-1;
		while(s<=e){
			int mid=(s+e)/2;
			if(v[mid]==k){
				se=mid;
				s=mid+1;
			}
			else if(v[mid]>k){
				e=mid-1;
			}
			else{
				s=mid+1;
			}
			
		}
        arr[0]=f;
        arr[1]=se;
        return arr;
        
    }
}