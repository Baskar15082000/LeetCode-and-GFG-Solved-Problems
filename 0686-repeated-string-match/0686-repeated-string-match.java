class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n=1;
        int count=0;
        int s=0;
        int large=b.length();
        if(a.length()>b.length()){
            large=a.length();
        }
        else{
            s=b.length();
        }
        if(a.contains(b)) return n;
        for(int i=0;i<b.length();i++){
            if(a.contains(""+b.charAt(i))){
                count++;
            }
        }
       if(count<s)return-1;
        
       String c=a;
        int limit=b.length();
        int t=0;
  //      System.out.print(a.contains(b));
        while(a.contains(b)!=true && (a.length()<=(large*10))){
              a=a+c;
             n++;
            if(a.contains(b)){
                t=1;

                break;
                
            }
          //   System.out.print("F");
          
          
        }
        if(t==1)return n;
        return -1;
    }
}