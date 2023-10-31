class Solution {
    public int compress(char[] chars) {
//         int i=1;
//         int n=chars.length;
//         int co=0;
//         int id=0;
//         char c=chars[0];
//         if(n==1)return 1;
            
//         while(i<n){
//             if(c==chars[i]){
//                 co++;
//             }
//             else{
                
               
//                 if(i+1<n && co>1){
//                     chars[id+1]=(char)((co+1)+'0');
//                     c=chars[i];
//                     id=i;
//                 }
//                 co=0;
//             }
//             i++;
//         }
//        chars[id+1]=(char)(co+'0');
     
//         return id+2;
        
        
          int s = 0; 
          int e = 0;

    while (e < chars.length) {
        char currentChar = chars[e];
        int count = 0;

       
        while (e < chars.length && chars[e] == currentChar) {
            e++;
            count++;
        }

      
        chars[s] = currentChar;
        s++;

       
        if (count > 1) {
            String countStr = String.valueOf(count);
            for (char c : countStr.toCharArray()) {
                chars[s] = c;
                s++;
            }
        }
    }

    return s;

    }
}