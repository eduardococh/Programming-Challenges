        /*Simple and elegant solution by yavinci
          it comes down to the formula
          `num1[i] * num2[j]` will be placed at indices `[i + j` , `i + j + 1]`
                                                            p1         p2
           in every multiplication we multiply i*j, then add whatever p2 might have
           and then save every digit in their place
           Indices start with 0 at left for numbers and result
           Good runtime of 3ms better than 89.94% O(M*N)
           Bad memory better than only 16% O(M+N)
        */
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
    
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
        
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }       
      
      
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