//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int arr[], int n) {
        
        // Your code here
        		int trainmax=0;
		int trainmin=0;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		int total=0;
		for(int i=0;i<n;i++){
			total+=arr[i];
			int pre1=trainmax+arr[i];
			int newt=arr[i];
			int pre2=trainmin+arr[i];
			trainmax=Math.max(pre1,newt);
			max=Math.max(max,trainmax);
			trainmin=Math.min(pre2,newt);
			min=Math.min(trainmin,min);
			
		}
		int around=total-min;
		if(total==min)return max;
		return Math.max(around,max);

    }
    
}

