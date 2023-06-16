//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int nums[], int n)
    {
        // your code here
        Arrays.sort(nums);
        int max=-1;
        int t=nums[0];
        int count=0;
        
        for(int i=0;i<nums.length;i++){
            
                if(t==nums[i]){
                  
                    count++;
                    //System.out.print(count);
                }
                if(count>(nums.length/2) ){
                
                
                max=nums[i];
               
                break;
                }
            else if(t!=nums[i]){
                t=nums[i];
                count=1;
                
            }
            
        
        }
        return max;
    }
}