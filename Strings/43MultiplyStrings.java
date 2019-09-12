        //My solution
        //Bad runtime at 23ms O(N*M) better than only 10.85%
        //Good memory better than 86.67%
        //It works, but it is really complex
        //It handles everything as a digit, no two digits here
        //which is the main difference with better runtimes
class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder results[]=new StringBuilder[num2.length()];
        int shifting=0;
        int length1=num1.length(),length2=num2.length();
        int carry=0;
        for(int i=length2-1;i>=0;i--){
            results[length2-i-1]=new StringBuilder("");
            for(int j=0;j<shifting;j++){
                results[length2-i-1].append("0");
            }
            carry=0;
            for(int j=length1-1;j>=0;j--){
                int result=(num1.charAt(j)-48)*(num2.charAt(i)-48)+carry;
                carry=result/10;
                int num=result%10;
                //System.out.println("res "+result);
                //System.out.println("digit "+num);
                //System.out.println("carry "+carry);
                results[length2-i-1].insert(0,num);
            }
            if(carry!=0){
                results[length2-i-1].insert(0,carry);
            }
            shifting++;
        }
        
        StringBuilder result=new StringBuilder();
        int longest=results[num2.length()-1].length();
        for(StringBuilder sb:results){
            while(sb.length()<longest){
                sb.insert(0,"0");
            }
            //System.out.println(sb.toString());
        }
        carry=0;
        for(int i=longest-1;i>=0;i--){
            int current=0;
            for(StringBuilder sb:results){
                if(sb.length()>i){
                    //System.out.println("cahar "+sb.charAt(i));
                    current+=sb.charAt(i)-48;
                }
            }
            current+=carry;
            //System.out.println(current);
            carry=current/10;
            result.insert(0,current%10);
        }
        if(carry!=0){
            result.insert(0,carry);
        }
        boolean pure0=true;
        for(char c:result.toString().toCharArray()){
            if(c!='0'){
                pure0=false;
            }
        }
        if(pure0){
            return "0";
        }
        return result.toString();
    }
}

class Solution {
     public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1 + len2]; 
        for(int i=num1.length()-1; i >= 0; i--) {
            for(int j=num2.length()-1; j >= 0; j--) {
                //lead part of number
                int p1 = i + j;
                //carry + remainder
                int p2 = i + j + 1;
                //n1 * n2 + carry
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + result[p2];
                //put carry for next step
                result[p1] += num / 10;
                result[p2] = num % 10;
            }
        }
         StringBuilder fResult = new StringBuilder();
         for (int r: result) {
             //lead 0
             if (r == 0 && fResult.length() == 0)
                continue;
             fResult.append(r);
         }
         return fResult.length() == 0 ? "0" : fResult.toString();
    }
}