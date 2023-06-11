class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans="";
        int len=Integer.MIN_VALUE;
        if(strs.length==1){
            return strs[0];
        }
       int  k=0;
   //     k1=0;
        String s0=strs[0];
        for(int i=1;i<strs.length;i++){
            int count=0;
          for(int j=0;j<s0.length();j++){
                 String s1=s0;
                 String str="";
              
                  str =s1.substring(k,j+1);
                
                
                if(strs[i].startsWith(str) ){
                    
                    ans=str;
                    len=str.length();
                }
           }
            s0=ans;
            ans="";
            
        }
        return s0;
    }
}