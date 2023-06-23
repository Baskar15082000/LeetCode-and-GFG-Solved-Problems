//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int s=j+1;
                int e=arr.length-1;
                int temptar=k-arr[j]-arr[i];
                while(s<e){
                    int temp=arr[s]+arr[e];
                    if(temp<temptar){
                        s++;
                    }
                    else if(temp>temptar){
                        e--;
                    }
                    else{
                        ArrayList<Integer> list=new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[s]);
                        list.add(arr[e]);
                        ans.add(list);
                    
                    while(s<e && list.get(2)==arr[s]){
                        s++;
                    }
                    while(s<e && list.get(3)==arr[e]){
                        e--;
                    }
                    }
                }
                while(j+1<arr.length && arr[j+1]==arr[j]){
                    j++;
                }
               
            }
             while(i+1<arr.length && arr[i+1]==arr[i]){
                    i++;
                }
            
        }
        return ans;
    }
}