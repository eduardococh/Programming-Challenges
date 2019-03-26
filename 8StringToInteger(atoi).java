class Solution {
		//My solution (Very fast 100%, memory 26%) not the clearest
    public int myAtoi(String str) {
        str=str.trim();
        if(str==null || str.length()==0) return 0;
        String number="";
        int start=0;
        boolean isNegative=false,firstIsDigit=false;
        if(str.charAt(0)=='-'){
            isNegative=true;
            start=1;
        }else if(str.charAt(0)=='+'){
            start=1;
        }
        int result,prevRes=0;
        for(int i=start;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                firstIsDigit=true;
                number+=str.charAt(i);
                try{
                    result=Integer.parseInt(number);   
                }catch(NumberFormatException nfe){
                    if(isNegative){
                        return Integer.MIN_VALUE;
                    }else{
                        return Integer.MAX_VALUE;
                    }    
                }
                prevRes=result;
                if(i+1==str.length() || !Character.isDigit(str.charAt(i+1))){
                    break;
                }
            }else{
                if(firstIsDigit==false) return 0;
                continue;
            }
        }
        try{
            if(isNegative){
                return Integer.parseInt(number)*-1;
            }else{
                return Integer.parseInt(number);
            } 
        }catch(NumberFormatException nfe){
            return 0;   
        }
    }

	//clearer solution, same memory and time
    public int myAtoi(String str) {
          int index = 0, sign = 1, total = 0;
            //1. Empty string
            if(str.length() == 0) return 0;

            //2. Remove Spaces
            while(index < str.length() && str.charAt(index) == ' ' )
                index ++;

            //3. Handle signs
            if((index < str.length()) && (str.charAt(index) == '+' || str.charAt(index) == '-')){
                sign = str.charAt(index) == '+' ? 1 : -1;
                index ++;
            }

            //4. Convert number and avoid overflow
            while(index < str.length()){
                int digit = str.charAt(index) - '0';
                if(digit < 0 || digit > 9) break;

                //check if total will be overflow after 10 times and add digit
                if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

                total = 10 * total + digit;
                index ++;
            }
            return total * sign;
    }
}