//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public String code(String str){
		char arr[] =new char[26];
		
		for(int i=0;i<str.length();i++){
			char ch=str.charAt(i);
			int a=(ch-'a');
		//	System.out.print(a);
			arr[a]++;
		}
		StringBuilder sb=new StringBuilder("");
		for(int i=0;i<arr.length;i++){
			if(arr[i]>0){
				sb.append((char)'a'+i);
				sb.append(arr[i]);
			}
		}
	//	System.out.print(sb);
		return sb.toString();
	}
    public List<List<String>> Anagrams(String[] wordArr) {
        // Code here
        List<List<String>> ans=new ArrayList<>();
        HashMap<String,ArrayList<String>> map1=new HashMap<>();
		ArrayList<String> list=new ArrayList<>();
		for(String val:wordArr){
			String str=code(val);
			if(map1.containsKey(str)){
				ArrayList<String> s=map1.get(str);
				s.add(val);
				map1.put(str,s);
			}
			else{
				ArrayList<String> s=new ArrayList<>();
				list.add(val);
				s.add(val);
				map1.put(str,s);
			}
		}
		Collections.sort(list);
		for(String val:list){
			String key=code(val);
			List<String> l=map1.get(key);
		    ans.add(l);
		}
		return ans;
    }
}
