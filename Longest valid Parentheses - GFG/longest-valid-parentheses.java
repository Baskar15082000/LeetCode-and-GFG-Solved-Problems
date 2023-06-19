//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        // code here
        Stack<Character> st=new Stack<>();
         Stack<Integer> aux=new Stack<>();
         aux.push(-1);
        int count=0;
        int ans=0;
        int temp=0;
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            if(ch=='('){
                
                st.push(ch);
                aux.push(i);
            }
            else{
                if( st.size()>0 && st.peek()=='(' && ch==')'){
                    aux.pop();
                   
                    st.pop();
                     ans=Math.max(ans,i-aux.peek());
                   // if(i==(S.length()-1)) return Math.max(count*2,ans*2);
                    
                    
                }
                else{
                    aux.push(i);
                }
              
                 
           
           
            }
        }
       // if(temp==0 && ans!=0 && ans>count)    return count*2;
         return ans;
         
        
    }
}