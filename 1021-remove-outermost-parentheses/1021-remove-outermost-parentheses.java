class Solution {
    public String removeOuterParentheses(String s) {
        String result="";
        String temp="";
        int count=0;
        for(int i=0;i<s.length();i++){
          char c=s.charAt(i);
          if(c=='('){
              count++;
          }  
          else{
              count--;
          }
          temp+=c;
          if(count==0){
              result+=temp.substring(1,temp.length()-1);
              temp="";
          }  
        }
        return result;
    }
}