class Solution {
    public String longestPalindrome(String s) {
            String str="";
            int length =Integer.MIN_VALUE;
        
        StringBuilder sb=new StringBuilder(s);
       int i=0;
        int j=0;
        while(i<s.length()&&j<s.length()){
                   StringBuilder sb1=new StringBuilder( sb.substring(i,j+1));
         
                  j++;
                  if((ispos(sb1)) && (sb1.length()>length)){
                      str=sb1.toString();
                      length=sb1.length();
                  }
                  else if(j==s.length()){
                    
                      i++;
                      int a=i;
                      j=a;
                  }
          }
        
        return str;
    }
    boolean ispos(StringBuilder s){
        int left=0;
        int right=s.length()-1;
          while (left <= right ){ 
              if(s.charAt(left) != s.charAt(right)){
                  return false;
              } 
            left++;
            right--;
        }
        // Return the length of the palindrome
        return true;
    }
}