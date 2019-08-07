class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result=new StringBuilder("");
        final int num1l=num1.length();
        final int num2l=num2.length();
        final int minLength=num1l>num2l?num2l:num1l;
        int carry=0;
        for(int i=0;i<minLength;i++){
            char digit=(char)((((num1.charAt(num1l-i-1)-48+num2.charAt(num2l-i-1)-48)+carry)%10)+48);
            result.insert(0,digit);
            carry=((num1.charAt(num1l-i-1)-48+num2.charAt(num2l-i-1)-48)+carry)/10;
        }
        for(int i=minLength;i<num1l;i++){
            char digit=(char)(((num1.charAt(num1l-i-1)-48+carry)%10)+48);
            result.insert(0,digit);
            carry=(((num1.charAt(num1l-i-1)-48+carry)/10));
            
            //result.insert(0,(char)(num1.charAt(num1l-i-1)+carry));
            //carry=0;
        }
        for(int i=minLength;i<num2l;i++){
            char digit=(char)(((num2.charAt(num2l-i-1)-48+carry)%10)+48);
            result.insert(0,digit);
            carry=(((num2.charAt(num2l-i-1)+carry)-48)/10);
        }
        if(carry!=0){
            result.insert(0,(char)(carry+48));
        }
        return result.toString();
    }
}