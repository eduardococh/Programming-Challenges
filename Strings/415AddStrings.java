        //My solution
        //Really simple, the clearest way, go digit by digit summing, save the carry
        //If they are different length once we finish adding both we keep adding to the largest
        //string digits with carry
        //Where N is the length of longest string
        //Average runtime of 3ms better than 50.73% O(N), could be better but not bad
        //Amazing memory better than 100% O(N)
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

        //From leetcode's 1ms solution
        //Clever solution, biggest improvement over mine is usage of charArray which makes
        //a great improvement over string usage, also clever their use of '0' against my 48, their calculus is simpler
        //and clearer than my calculation also
        //Amazing runtime of 1ms better than 100% O(N)
        //Amazing memory better than 100%
class Solution {
    public String addStrings(String num1, String num2) {
        char[] charArr1 = num1.toCharArray();
        char[] charArr2 = num2.toCharArray();
        final int len1 = charArr1.length;
        final int len2 = charArr2.length;
        
        int carryOut;
        if (len1 >= len2) {
            carryOut = addShortCharArrToLongAndGetCarryOut(charArr1, charArr2);
        } else {
            carryOut = addShortCharArrToLongAndGetCarryOut(charArr2, charArr1);
        }
        
        StringBuilder sb = new StringBuilder();
        if (carryOut == 1) {
            sb.append(1);
        }
        sb.append(String.valueOf(len1 >= len2 ? charArr1 : charArr2));
        return sb.toString();
    }
    
    int addShortCharArrToLongAndGetCarryOut(char[] longArr, char[] shortArr) {
        int carryOut = 0;
        int i;
        int j;
        for (j = shortArr.length - 1, i = longArr.length - 1; j >= 0; i--, j--) {
            int sum = (longArr[i] - '0') + (shortArr[j] - '0') + carryOut;
            carryOut = sum / 10;
            longArr[i] = (char)(sum % 10 + '0');
        }
        
        for (; i >= 0; i--) {
            int sum = (longArr[i] - '0') + carryOut;
            carryOut = sum / 10;
            longArr[i] = (char)(sum % 10 + '0');
        }
        
        return carryOut;
    }
}