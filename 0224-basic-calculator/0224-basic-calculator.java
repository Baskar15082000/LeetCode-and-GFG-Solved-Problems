class Solution {
    public int calculate(String s) {
        Stack<Integer> value = new Stack<>();
        Stack<Integer> symbol = new Stack<>();
        int num=0;
        int sum=0;
        int sign=1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=(num*10)+(c-'0');
                
            }
            else if(c=='+'){
                sum+=num*sign;
                num=0;
                sign=1;
            }
            else if(c=='-'){
                sum+=num*sign;
                num=0;
                sign=-1;
            }
            else if(c=='('){
                value.push(sum);
                symbol.push(sign);
                sum=0;
                sign=1;
            }
            else if(c==')'){
                sum+=num*sign;
                num=0;
                sum*=symbol.pop();
                sum+=value.pop();
            }
        }
        if(num!=0){
            sum+=sign*num;
        }
        return sum;
    }
}