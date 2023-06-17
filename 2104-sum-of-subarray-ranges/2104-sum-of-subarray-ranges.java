class Solution {
    	public int[] right(int n, int arr[]){
		// write code here
		Stack<Integer>st=new Stack<>();
		int right[]=new int[n];
		for(int i=0;i<n;i++){
			while(st.size()>0 && arr[i]<=arr[st.peek()]){
				right[st.pop()]=i;
			}
			st.push(i);
		}
		while(st.size()>0){
			right[st.pop()]=n;
		}
		return right;
		
	}
	public int[] left(int n, int arr[]){
		// write code here
		Stack<Integer>st=new Stack<>();
		int left[]=new int[n];
		for(int i=n-1;i>=0;i--){
			while(st.size()>0 && arr[i]<arr[st.peek()]){
				left[st.pop()]=i;
			}
			st.push(i);
		}
		while(st.size()>0){
			left[st.pop()]=-1;
		}
		return left;
		
	}
	
	public long minSubarraySum(int n, int a[]){
		// write code here
		int left[]=left(n,a);
		int right[]=right(n,a);
		long minsum=0l;
		for(int i=0;i<n;i++){
			long noofarray=(i-left[i])*(right[i]-i);
			minsum=minsum+((noofarray)*(a[i]));
		}
		return minsum;
    }
    	public int[] rightmax(int n, int arr[]){
		// write code here
		Stack<Integer>st=new Stack<>();
		int right[]=new int[n];
		for(int i=0;i<n;i++){
			while(st.size()>0 && arr[i]>=arr[st.peek()]){
				right[st.pop()]=i;
			}
			st.push(i);
		}
		while(st.size()>0){
			right[st.pop()]=n;
		}
		return right;
		
	}
	public int[] leftmax(int n, int arr[]){
		// write code here
		Stack<Integer>st=new Stack<>();
		int left[]=new int[n];
		for(int i=n-1;i>=0;i--){
			while(st.size()>0 && arr[i]>arr[st.peek()]){
				left[st.pop()]=i;
			}
			st.push(i);
		}
		while(st.size()>0){
			left[st.pop()]=-1;
		}
		return left;
		
	}
	
	public long maxSubarraySum(int n, int a[]){
		// write code here
		int left[]=leftmax(n,a);
		int right[]=rightmax(n,a);
		long minsum=0l;
		for(int i=0;i<n;i++){
			long noofarray=(i-left[i])*(right[i]-i);
			minsum=minsum+((noofarray)*(a[i]));
		}
		return minsum;
    }
    public long subArrayRanges(int[] nums) {
     minSubarraySum(nums.length,nums);
         return maxSubarraySum(nums.length,nums)- minSubarraySum(nums.length,nums);
        
    }
}